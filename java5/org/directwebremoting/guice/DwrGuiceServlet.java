/*
 * Copyright 2007 Tim Peierls
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
package org.directwebremoting.guice;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.directwebremoting.Container;
import org.directwebremoting.extend.Configurator;
import org.directwebremoting.servlet.DwrServlet;

import static org.directwebremoting.guice.Constants.CLASSES;
import static org.directwebremoting.guice.Constants.DEBUG;
import static org.directwebremoting.guice.Constants.INIT_CLASSES;
import static org.directwebremoting.guice.Constants.INIT_DEBUG;
import static org.directwebremoting.guice.DwrGuiceUtil.getInjector;
import static org.directwebremoting.impl.ContainerUtil.INIT_CUSTOM_CONFIGURATOR;

/**
 * An extension of the basic {@link DwrServlet} that configures itself for
 * dependency injection with Guice. Must be used in conjunction with
 * {@link DwrGuiceServletContextFilter}.
 * @author Tim Peierls [tim at peierls dot net]
 */
public class DwrGuiceServlet extends DwrServlet {

    /**
     * Injects some DWR configuration values from the Guice bindings
     * to <code>servletConfig</code> (by decorating it, since
     * <code>ServletConfig</code> is immutable) to make these values
     * accessible to the standard DWR servlet configuration machinery.
     * <p>
     * Currently only the debug setting, the list of classes to scan for
     * annotations, the custom Configurator class, and the Container class
     * are copied in this way. (You can always write your own custom Container
     * if you really want complete configurability via Guice dependency injection.)
     * </p>
     */
    @Override public void init(ServletConfig servletConfig) throws ServletException
    {
        getInjector(servletConfig.getServletContext()).injectMembers(this);

        LocalServletConfig config = new LocalServletConfig(servletConfig);

        config.addInitParameter(INIT_DEBUG, debug);
        config.addInitParameter(INIT_CLASSES, classes);
        config.addInitParameter(INIT_CUSTOM_CONFIGURATOR, configurator);
        config.addInitParameter(Container.class.getName(), container);

        super.init(config);
    }

    @Inject(optional=true) @Named(DEBUG) Boolean debug = null;
    @Inject(optional=true) @Named(CLASSES) List<Class> classes = null;
    @Inject(optional=true) Configurator configurator = null;
    @Inject(optional=true) Container container = null;

    private static class LocalServletConfig extends OverridableServletConfig
    {
        LocalServletConfig(ServletConfig servletConfig)
        {
            super(servletConfig);
        }

        void addInitParameter(String name, Object value)
        {
            if (value != null)
            {
                String stringValue;

                if (INIT_DEBUG.equals(name))
                {
                    // Boolean -> { "true", "false" }
                    stringValue = "" + value;
                }
                else if (INIT_CLASSES.equals(name))
                {
                    // list of classes -> stringified list of class names
                    StringBuilder buf = new StringBuilder();
                    int count = 0;
                    for (Class cls : (List<Class>) value)
                    {
                        if (count++ > 0) buf.append(", ");
                        buf.append(cls.getName());
                    }
                    stringValue = buf.toString();
                }
                else
                {
                    // Instance used as prototype, assumes but does not
                    // check for existence of accessible parameterless
                    // constructor.
                    stringValue = value.getClass().getName();
                }

                setInitParameter(name, stringValue);
            }
        }
    }
}
