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
package org.directwebremoting.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.directwebremoting.extend.ServerLoadMonitor;
import org.directwebremoting.extend.WaitController;

/**
 * A base implementation of {@link ServerLoadMonitor} that implements waiting
 * functionallity, mostly to provide {@link #shutdown()}.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public abstract class AbstractServerLoadMonitor implements ServerLoadMonitor
{
    /* (non-Javadoc)
     * @see org.directwebremoting.extend.ServerLoadMonitor#threadWaitStarting(org.directwebremoting.extend.WaitController)
     */
    public void threadWaitStarting(WaitController controller)
    {
        waitControllers.add(controller);
    }

    /* (non-Javadoc)
     * @see org.directwebremoting.extend.ServerLoadMonitor#threadWaitEnding(org.directwebremoting.extend.WaitController)
     */
    public void threadWaitEnding(WaitController controller)
    {
        waitControllers.remove(controller);
    }

    /* (non-Javadoc)
     * @see org.directwebremoting.extend.ServerLoadMonitor#shutdown()
     */
    public void shutdown()
    {
        for (Iterator it = waitControllers.iterator(); it.hasNext();)
        {
            WaitController controller = (WaitController) it.next();
            controller.shutdown();
        }
    }

    /**
     * The known wait controllers
     */
    protected List waitControllers = new ArrayList();
}
