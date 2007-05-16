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

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

import org.mortbay.cometd.Bayeux;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class BayeuxServletContextAttributeListener implements ServletContextAttributeListener
{
    /* (non-Javadoc)
     * @see javax.servlet.ServletContextAttributeListener#attributeAdded(javax.servlet.ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent scab)
    {
        synchronized (this)
        {
            if (bayeuxHandler == null && "org.mortbay.bayeux".equals(scab.getName()))
            {
                Bayeux bayeux = (Bayeux) scab.getValue();
                bayeuxHandler = new BayeuxClient(bayeux);
            }
        }
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletContextAttributeListener#attributeRemoved(javax.servlet.ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent scab)
    {
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletContextAttributeListener#attributeReplaced(javax.servlet.ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent scab)
    {
    }

    private BayeuxClient bayeuxHandler;
}
