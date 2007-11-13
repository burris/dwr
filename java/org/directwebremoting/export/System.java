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
package org.directwebremoting.export;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.extend.CallbackHelper;
import org.directwebremoting.extend.RealWebContext;
import org.directwebremoting.extend.ScriptSessionManager;
import org.directwebremoting.io.RawData;

/**
 * Various functions exported by DWR to help us with various book-keeping
 * duties.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class System
{
    /**
     * A method designed to be called on page load so the client knows about
     * the http and script sessions.
     * @return The newly created scriptSessionId
     */
    public String pageLoaded()
    {
        RealWebContext webContext = (RealWebContext) WebContextFactory.get();

        // Create a script session and tell the client about the id
        ScriptSessionManager scriptSessionManager = webContext.getContainer().getBean(ScriptSessionManager.class);
        String scriptSessionId = scriptSessionManager.createScriptSession(webContext);

        log.debug("scriptSession created: " + scriptSessionId);
        return scriptSessionId;
    }

    /**
     * Call {@link ScriptSession#invalidate()} on the {@link ScriptSession}
     * that called this method.
     * Used by the page unloader.
     */
    public void pageUnloaded()
    {
        WebContext wctx = WebContextFactory.get();
        ScriptSession scriptSession = wctx.getScriptSession();

        log.debug("scriptSession.invalidate(): " + scriptSession.getId());
        scriptSession.invalidate();
    }

    /**
     * Used by reverse ajax proxies to send data back to the server
     * @param key The unique id under which a callback is registered
     * @param data The data to decode and pass to the callback
     */
    public void activateCallback(String key, RawData data)
    {
        try
        {
            CallbackHelper.executeCallback(key, data);
        }
        catch (Exception ex)
        {
            log.error("Failed to marshall data from callback", ex);
        }
    }

    /**
     * The log stream
     */
    private static final Log log = LogFactory.getLog(System.class);
}
