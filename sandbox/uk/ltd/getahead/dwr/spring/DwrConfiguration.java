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

package uk.ltd.getahead.dwr.spring;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import uk.ltd.getahead.dwr.Converter;
import uk.ltd.getahead.dwr.Creator;
import uk.ltd.getahead.dwr.CreatorManager;
import uk.ltd.getahead.dwr.Processor;
import uk.ltd.getahead.dwr.WebContextBuilder;
import uk.ltd.getahead.dwr.impl.DefaultAccessControl;
import uk.ltd.getahead.dwr.impl.DefaultAjaxFilterManager;
import uk.ltd.getahead.dwr.impl.DefaultConfiguration;
import uk.ltd.getahead.dwr.impl.DefaultConverterManager;
import uk.ltd.getahead.dwr.impl.DefaultCreatorManager;
import uk.ltd.getahead.dwr.impl.DefaultExecProcessor;
import uk.ltd.getahead.dwr.impl.DefaultIndexProcessor;
import uk.ltd.getahead.dwr.impl.DefaultInterfaceProcessor;
import uk.ltd.getahead.dwr.impl.DefaultProcessor;
import uk.ltd.getahead.dwr.impl.DefaultTestProcessor;
import uk.ltd.getahead.dwr.impl.DefaultWebContextBuilder;
import uk.ltd.getahead.dwr.impl.FileProcessor;

/**
 * The <code>Configuration</code> implementation for use in the Spring IoC container. <br>
 * It adheres to the JavaBean specification and provides sensible defaults (the DWR default
 * implementations) for convenience and ease-of-use.
 *
 * <p>Use this class to provide the DWR configuration in a Spring application context.
 * You need to use the <code>DwrSpringServlet</code> in order for the configuration to
 * be used.</p>
 *
 * <p>A simple configuration in Spring to expose an existing bean by id
 * '<code>categoryManager</code>' is something like the following:
 * <pre>
 * &lt;bean id="dwrConfiguration" class="uk.ltd.getahead.dwr.spring.DwrConfiguration"&gt;
 *     &lt;property name="converters"&gt;
 *         &lt;map>
 *             &lt;entry key="org.springtip.data.*"&gt;
 *                 &lt;bean class="uk.ltd.getahead.dwr.convert.BeanConverter"/&gt;
 *             &lt;/entry&gt;
 *         &lt;/map&gt;
 *     &lt;/property&gt;
 *     &lt;property name="creators"&gt;
 *         &lt;list&gt;
 *             &lt;bean class="uk.ltd.getahead.dwr.spring.BeanCreator"&gt;
 *                 &lt;property name="javascript" value="categoryManager"/&gt;
 *                 &lt;property name="bean" <b>ref="categoryManager"</b>/&gt;
 *             &lt;/bean&gt;
 *         &lt;/list&gt;
 *     &lt;/property&gt;
 *     &lt;property name="debug" value="true"/&gt;
 * &lt;/bean&gt;
 * </pre></p>
 *
 * @see uk.ltd.getahead.dwr.DwrSpringServlet
 *
 * @author Bram Smeets
 */
public class DwrConfiguration extends DefaultConfiguration implements InitializingBean
{
    /** The web context builder for this configuration. */
    private WebContextBuilder webContextBuilder;

    /** The processor for this configuration. */
    private Processor processor;

    /** The indication of the debug mode for this configuration. */
    private boolean debug = false;

    /** The map containing all match patterns and their corrosponding converters to register. */
    private Map converters;

    /** The list containing all creators to register. */
    private List creators;

    /**
     * Sets the debug mode for this configuration.
     *
     * @param debug the debug mode
     *
     * @see CreatorManager#setDebug(boolean)
     */
    public void setDebug(boolean debug)
    {
        this.debug = debug;
    }

    /**
     * Sets the converters to register with the converter manager.
     *
     * @param converters the map containing match patterns and their corrospondig converters
     */
    public void setConverters(Map converters)
    {
        this.converters = converters;
    }

    /**
     * Sets the creators to register with the creator manager.
     *
     * @param creators the list containing all creators
     */
    public void setCreators(List creators)
    {
        this.creators = creators;
    }

    /**
     * Gets the web context builder for this configuration.
     *
     * @return the web context builder
     */
    public WebContextBuilder getWebContextBuilder()
    {
        return webContextBuilder;
    }

    /**
     * Sets the web context builder for this configuration.
     *
     * @param webContextBuilder the web context builder
     */
    public void setWebContextBuilder(WebContextBuilder webContextBuilder)
    {
        this.webContextBuilder = webContextBuilder;
    }

    /**
     * Gets the processor for this configuration.
     *
     * @return the processor for this configuration
     */
    public Processor getProcessor()
    {
        return processor;
    }

    /**
     * Sets the processor for this configuration.
     *
     * @param processor the processor for this configuration
     */
    public void setProcessor(Processor processor)
    {
        this.processor = processor;
    }

    /**
     * Implementation of the <code>InitializingBean</code> interface. <br>
     * It is called by the Spring IoC container to initialize the bean after
     * all properties have been set.
     * <p>It is implemented to provide sensible defaults for required properties
     * and process the registered converters and creators.
     */
    public void afterPropertiesSet()
    {
        // make sure to set all the default implementations in case they are not set
        if (getCreatorManager() == null)
        {
            setCreatorManager(new DefaultCreatorManager());
        }
        if (getConverterManager() == null)
        {
            setConverterManager(new DefaultConverterManager());
        }
        if (getAccessControl() == null)
        {
            setAccessControl(new DefaultAccessControl());
        }
        if (getAjaxFilterManager() == null)
        {
            setAjaxFilterManager(new DefaultAjaxFilterManager());
        }
        if (webContextBuilder == null)
        {
            webContextBuilder = new DefaultWebContextBuilder();
        }
        if (processor == null)
        {
            processor = createDefaultProcessor();
        }

        // set the requested debug mode on the creator manager
        getCreatorManager().setDebug(debug);

        // process all registered converters
        if (converters != null)
        {
            Iterator it = converters.keySet().iterator();
            while (it.hasNext())
            {
                String match = (String) it.next();
                Converter converter = (Converter) converters.get(match);
                // make sure all converters have the correct converter manager
                converter.setConverterManager(getConverterManager());
                getConverterManager().addConverter(match, converter);
            }
        }

        // process all registered creators
        if (creators != null)
        {
            Iterator it = creators.iterator();
            while (it.hasNext())
            {
                Creator creator = (Creator) it.next();
                addCreator(creator.getJavascript(), creator);
            }
        }
    }

    /**
     * Create and configure the default processor.
     */
    private Processor createDefaultProcessor()
    {
        DefaultProcessor defaultProcessor = new DefaultProcessor();

        DefaultExecProcessor execProcessor = new DefaultExecProcessor();
        execProcessor.setCreatorManager(getCreatorManager());
        execProcessor.setConverterManager(getConverterManager());
        execProcessor.setAjaxFilterManager(getAjaxFilterManager());
        execProcessor.setAccessControl(getAccessControl());
        defaultProcessor.setExec(execProcessor);

        DefaultInterfaceProcessor interfaceProcessor = new DefaultInterfaceProcessor();
        interfaceProcessor.setCreatorManager(getCreatorManager());
        interfaceProcessor.setAccessControl(getAccessControl());
        defaultProcessor.setInterface(interfaceProcessor);

        DefaultIndexProcessor indexProcessor = new DefaultIndexProcessor();
        indexProcessor.setCreatorManager(getCreatorManager());
        defaultProcessor.setIndex(indexProcessor);

        DefaultTestProcessor testProcessor = new DefaultTestProcessor();
        testProcessor.setCreatorManager(getCreatorManager());
        testProcessor.setConverterManager(getConverterManager());
        testProcessor.setAccessControl(getAccessControl());
        defaultProcessor.setTest(testProcessor);

        defaultProcessor.setFile(new FileProcessor());

        return defaultProcessor;
    }
}
