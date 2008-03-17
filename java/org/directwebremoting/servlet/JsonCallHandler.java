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
package org.directwebremoting.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.directwebremoting.extend.Calls;
import org.directwebremoting.extend.Handler;
import org.directwebremoting.extend.Remoter;
import org.directwebremoting.extend.Replies;
import org.directwebremoting.json.JsonCallMarshaller;

/**
 * A Handler JSON/REST DWR calls
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class JsonCallHandler implements Handler
{
    /* (non-Javadoc)
     * @see org.directwebremoting.Handler#handle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        if (!jsonEnabled)
        {
            log.warn("JSON request denied. To enable JSON mode add an init-param of jsonEnabled=true to web.xml");
            throw new SecurityException("JSON interface disabled");
        }

        Calls calls;

        try
        {
            calls = jsonCallMarshaller.marshallInbound(request, response);
        }
        catch (Exception ex)
        {
            jsonCallMarshaller.marshallException(request, response, ex);
            return;
        }

        Replies replies = remoter.execute(calls);
        jsonCallMarshaller.marshallOutbound(replies, request, response);
    }

    /**
     * Setter for the Plain Javascript Marshaller
     * @param jsonCallMarshaller The new marshaller
     */
    public void setJsonCallMarshaller(JsonCallMarshaller jsonCallMarshaller)
    {
        this.jsonCallMarshaller = jsonCallMarshaller;
    }

    /**
     * Setter for the remoter
     * @param remoter The new remoter
     */
    public void setRemoter(Remoter remoter)
    {
        this.remoter = remoter;
    }

    /**
     * Are we allowing remote hosts to contact us using JSON?
     */
    protected boolean jsonEnabled = false;

    /**
     * The 'HTML Javascript' method by which objects are marshalled
     */
    protected JsonCallMarshaller jsonCallMarshaller = null;

    /**
     * The bean to execute remote requests and generate interfaces
     */
    protected Remoter remoter = null;

    /**
     * The log stream
     */
    private static final Log log = LogFactory.getLog(JsonCallHandler.class);
}
