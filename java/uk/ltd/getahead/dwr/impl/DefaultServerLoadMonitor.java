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
package uk.ltd.getahead.dwr.impl;

import uk.ltd.getahead.dwr.ServerLoadMonitor;
import uk.ltd.getahead.dwr.util.Logger;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class DefaultServerLoadMonitor implements ServerLoadMonitor 
{
    private int concurrentPages = 0;
    private int activeServlets = 0;

    private int recommendedConnectTime = 0;
    private int recommendedPauseTime = 0;

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.ServerLoadMonitor#waitForAction()
     */
    public int timeToNextPoll()
    {
        /*
        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException ex)
        {
            log.warn("Interrupted while polling: " + ex.getMessage()); //$NON-NLS-1$
        }
        */

        return 3000;
    }

    /**
     * The log stream
     */
    private static final Logger log = Logger.getLogger(DefaultServerLoadMonitor.class);
}
