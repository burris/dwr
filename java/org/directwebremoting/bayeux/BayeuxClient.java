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

import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.directwebremoting.WebContextFactory.WebContextBuilder;
import org.directwebremoting.dwrp.Batch;
import org.directwebremoting.extend.Calls;
import org.directwebremoting.extend.ConverterManager;
import org.directwebremoting.extend.EnginePrivate;
import org.directwebremoting.extend.Remoter;
import org.directwebremoting.extend.Replies;
import org.directwebremoting.extend.Reply;
import org.directwebremoting.extend.ScriptConduit;
import org.directwebremoting.impl.ContainerUtil;
import org.directwebremoting.impl.DefaultContainer;
import org.directwebremoting.impl.DwrXmlConfigurator;
import org.directwebremoting.impl.StartupUtil;
import org.mortbay.cometd.Bayeux;
import org.mortbay.cometd.Channel;
import org.mortbay.cometd.ChannelId;
import org.mortbay.cometd.Client;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class BayeuxClient extends Client
{
    public BayeuxClient(Bayeux bayeux)
    {
        super(bayeux, "dwr");
        this.bayeux = bayeux;
        channel = bayeux.getChannel("/dwr", true);
        channel.addSubscriber(this);

        try
        {
            ServletConfig servletConfig = null;
            ServletContext servletContext = null;

            container = ContainerUtil.createDefaultContainer(servletConfig);
            ContainerUtil.setupDefaultContainer(container, servletConfig);

            webContextBuilder = StartupUtil.initWebContext(servletConfig, servletContext, container);
            StartupUtil.initServerContext(servletConfig, servletContext, container);
            ContainerUtil.prepareForWebContextFilter(servletContext, servletConfig, container, webContextBuilder, null);

            ContainerUtil.configureFromSystemDwrXml(container);

            DwrXmlConfigurator local = new DwrXmlConfigurator();
            local.setClassResourceName("/dwr.xml");
            local.configure(container);

            ContainerUtil.configureFromInitParams(container, servletConfig);

            ContainerUtil.publishContainer(container, servletConfig);
        }
        catch (Exception ex)
        {
            throw new IllegalStateException(ex);
        }
        finally
        {
            if (webContextBuilder != null)
            {
                webContextBuilder.unset();
            }
        }
    }

    /* (non-Javadoc)
     * @see org.mortbay.cometd.Client#deliver(org.mortbay.cometd.Client, org.mortbay.cometd.ChannelId, java.util.Map)
     */
    @Override
    protected void deliver(Client from, ChannelId to, Map<String, Object> message)
    {
        try
        {
            Batch batch = new Batch((Map) message);
            Calls calls = batch.getCalls();

            ScriptConduit conduit = new BayeuxScriptConduit(converterManager);

            Replies replies = remoter.execute(calls);
            for (Reply reply : replies)
            {
                String batchId = calls.getBatchId();

                if (reply.getThrowable() != null)
                {
                    Throwable ex = reply.getThrowable();
                    EnginePrivate.remoteHandleException(conduit, batchId, reply.getCallId(), ex);

                    log.warn("--Erroring: batchId[" + batchId + "] message[" + ex.toString() + ']');
                }
                else
                {
                    Object data = reply.getReply();
                    EnginePrivate.remoteHandleCallback(conduit, batchId, reply.getCallId(), data);
                }
            }

            String output = conduit.toString();
            ChannelId channelId = bayeux.getChannelId("/dwr/" + from.getId());
            bayeux.publish(channelId, this, output, calls.getBatchId());
        }
        catch (Exception ex)
        {
            log.warn("Protocol Error", ex);
        }
    }

    private DefaultContainer container;

    private WebContextBuilder webContextBuilder;

    private Bayeux bayeux;

    private Channel channel;

    private Remoter remoter;

    private ConverterManager converterManager;

    /**
     * The log stream
     */
    private static final Log log = LogFactory.getLog(BayeuxClient.class);
}
