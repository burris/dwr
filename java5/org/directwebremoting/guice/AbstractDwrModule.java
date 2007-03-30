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

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import static com.google.inject.name.Names.named;

import java.util.List;
import static java.util.Arrays.asList;

import org.directwebremoting.extend.Configurator;
import static org.directwebremoting.guice.Constants.DEBUG;
import static org.directwebremoting.guice.Constants.CLASSES;

/**
 * An extension of {@link AbstractModule} that adds DWR configuration methods,
 * in conjunction with {@link DwrGuiceServlet}.
 * @author Tim Peierls [tim at peierls dot net]
 */
public abstract class AbstractDwrModule extends AbstractModule
{
    /**
     * Implement this method to configure Guice bindings for the servlet context.
     */
    protected abstract void configure();


    /**
     * Call this method in {@link AbstractDwrModule#configure configure}
     * to specify a Configurator implementation (which must be public and
     * have a public parameterless constructor).
     */
    protected void setConfiguratorClass(Class<? extends Configurator> configuratorClass)
    {
        bind(Configurator.class)
            .to(configuratorClass);
    }


    /**
     * Call this method in {@link AbstractDwrModule#configure configure}
     * to specify a debug setting for DWR.
     */
    protected void setDebug(boolean debug)
    {
        bindConstant()
            .annotatedWith(named(DEBUG))
            .to(debug);
    }

    /**
     * Call this method in {@link AbstractDwrModule#configure configure}
     * to specify classes that DWR should scan for annotations.
     */
    protected void setAnnotatedClasses(Class... classes)
    {
        bind(new TypeLiteral<List<Class>>(){})
            .annotatedWith(named(CLASSES))
            .toInstance(asList(classes));

    }
}
