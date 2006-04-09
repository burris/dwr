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
package org.directwebremoting.remoted;

import org.directwebremoting.Container;
import org.directwebremoting.ServerLoadMonitor;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.util.Logger;

/**
 * A collection of system level actions that can be called remotely.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class DwrSystem
{
    /**
     * The polling system needs to be able to wait for something to happen
     * @return How long should the client wait until it next polls
     */
    public int poll()
    {
        Container container = WebContextFactory.get().getContainer();
        ServerLoadMonitor monitor = (ServerLoadMonitor) container.getBean(ServerLoadMonitor.class.getName());

        // The comet part of a poll request
        try
        {
            long sleepTime = monitor.timeWithinPoll();
            Thread.sleep(sleepTime);
        }
        catch (InterruptedException ex)
        {
            log.warn("Interupted", ex); //$NON-NLS-1$
        }

        return monitor.timeToNextPoll();
    }

    /**
     * The log stream
     */
    private static final Logger log = Logger.getLogger(DwrSystem.class);
}
