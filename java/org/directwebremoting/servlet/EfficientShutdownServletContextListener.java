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

import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.directwebremoting.Container;
import org.directwebremoting.extend.ServerLoadMonitor;
import org.directwebremoting.impl.ContainerUtil;
import org.directwebremoting.util.Logger;

/**
 * A {@link ServletContextListener} that can be used to call
 * {@link ServerLoadMonitor#shutdown()} when the servlet container is stopped
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class EfficientShutdownServletContextListener implements ServletContextListener
{
    /* (non-Javadoc)
     * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent ev)
    {
        List containers = ContainerUtil.getAllPublishedContainers(ev.getServletContext());
        for (Iterator it = containers.iterator(); it.hasNext();)
        {
            Container container = (Container) it.next();
            log.debug("ServerLoadMonitor.shutdown() for container: " + container);

            ServerLoadMonitor monitor = (ServerLoadMonitor) container.getBean(ServerLoadMonitor.class.getName());
            monitor.shutdown();
        }
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent ev)
    {
    }

    /**
     * The log stream
     */
    private static final Logger log = Logger.getLogger(EfficientShutdownServletContextListener.class);
}
