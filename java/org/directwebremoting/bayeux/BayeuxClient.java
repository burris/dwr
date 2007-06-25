/*
 * Copyright 2005 Joe Walker
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.directwebremoting.bayeux;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.directwebremoting.Container;
import org.directwebremoting.WebContextFactory.WebContextBuilder;
import org.directwebremoting.dwrp.Batch;
import org.directwebremoting.dwrp.PlainCallMarshaller;
import org.directwebremoting.extend.Call;
import org.directwebremoting.extend.Calls;
import org.directwebremoting.extend.ConverterManager;
import org.directwebremoting.extend.EnginePrivate;
import org.directwebremoting.extend.InboundContext;
import org.directwebremoting.extend.InboundVariable;
import org.directwebremoting.extend.MarshallException;
import org.directwebremoting.extend.Remoter;
import org.directwebremoting.extend.Replies;
import org.directwebremoting.extend.Reply;
import org.directwebremoting.extend.ScriptConduit;
import org.directwebremoting.extend.TypeHintContext;
import org.directwebremoting.impl.ContainerUtil;
import org.directwebremoting.impl.DefaultContainer;
import org.directwebremoting.impl.DwrXmlConfigurator;
import org.directwebremoting.impl.StartupUtil;
import dojox.cometd.Bayeux;
import dojox.cometd.Channel;
import dojox.cometd.Client;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class BayeuxClient implements dojox.cometd.Listener 
{
    public BayeuxClient(Bayeux bayeux)
    {
        this.bayeux = bayeux;
        this.client = bayeux.newClient("dwr", this);
        bayeux.subscribe("/dwr", client);
    }

    /* (non-Javadoc)
     * @see dojox.cometd.Listener#deliver(dojox.cometd.Client, java.lang.String, java.lang.Object, java.lang.String)
     */
    public void deliver(Client fromClient, String toChannel, Object message, String msgId)
    {
        System.err.println(">> "+message);
        try
        {
            Batch batch = new Batch((Map) message);
            Calls calls = plainCallMarshaller.marshallInbound(batch);
            
            System.err.println("Calls="+calls);
            
            for (int i=0;i<calls.getCallCount();i++)
            {
                Call call=calls.getCall(i);
                Object[] params=call.getParameters();
                System.err.println("Call["+i+"]="+call.getScriptName()+"."+call.getMethodName()+(params==null?"[]":Arrays.asList(params)));
            }

            Replies replies = remoter.execute(calls);
            
            ScriptConduit conduit = new BayeuxScriptConduit(converterManager);
            for (Reply reply : replies)
            {
                String batchId = calls.getBatchId();
                System.err.println("Reply="+reply+" BatchId="+batchId);

                if (reply.getThrowable() != null)
                {
                    Throwable ex = reply.getThrowable();
                    EnginePrivate.remoteHandleException(conduit, batchId, reply.getCallId(), ex);

                    log.warn("--Erroring: batchId[" + batchId + "] message[" + ex.toString() + ']');
                }
                else
                {
                    Object data = reply.getReply();
                    System.err.println("data="+data);
                    EnginePrivate.remoteHandleCallback(conduit, batchId, reply.getCallId(), data);
                }
            }
            
            String output = conduit.toString();
            System.err.println("<< "+output);
            bayeux.publish(client, "/dwr/"+fromClient.getId(), output, calls.getBatchId());
        }
        catch (Exception ex)
        {
            log.warn("Protocol Error", ex);
        }
        
    }

    /* (non-Javadoc)
     * @see dojox.cometd.Listener#removed(java.lang.String, boolean)
     */
    public void removed(String clientId, boolean timeout)
    {
        // TODO Auto-generated method stub
    }

    /**
     * @param remoter
     */
    public void setRemoter(Remoter remoter)
    {
        this.remoter=remoter;
    }

    /**
     * @param converterManager
     */
    public void setConverterManager(ConverterManager converterManager)
    {
        this.converterManager=converterManager;
    }

    /**
     * @param plainCallMarshaller
     */
    public void setPlainCallMarshaller(PlainCallMarshaller plainCallMarshaller)
    {
        this.plainCallMarshaller=plainCallMarshaller;
    }

    private Bayeux bayeux;

    private Client client;

    private Remoter remoter;

    private ConverterManager converterManager;
    
    private PlainCallMarshaller plainCallMarshaller;

    /**
     * The log stream
     */
    private static final Log log = LogFactory.getLog(BayeuxClient.class);
}
