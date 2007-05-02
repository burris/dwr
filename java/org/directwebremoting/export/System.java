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

import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.util.Logger;

/**
 * Various functions exported by DWR to help us with various book-keeping
 * duties.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class System
{
    /**
     * Call {@link ScriptSession#invalidate()} on the {@link ScriptSession}
     * that called this method.
     * Used by the page unloader.
     */
    public void pageUnloaded()
    {
        WebContext wctx = WebContextFactory.get();
        ScriptSession scriptSession = wctx.getScriptSession();

        log.debug("scriptSession.invalidate() on " + scriptSession.getId());
        scriptSession.invalidate();
    }

    /**
     * The log stream
     */
    private static final Logger log = Logger.getLogger(System.class);
}
