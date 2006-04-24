/*
 * Copyright 2006 Maik Schreiber <blizzy AT blizzy DOT de>
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
package org.directwebremoting.annotations;

import java.beans.Introspector;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.directwebremoting.AccessControl;
import org.directwebremoting.AjaxFilter;
import org.directwebremoting.AjaxFilterManager;
import org.directwebremoting.Configurator;
import org.directwebremoting.Container;
import org.directwebremoting.ConverterManager;
import org.directwebremoting.CreatorManager;
import org.directwebremoting.convert.BeanConverter;
import org.directwebremoting.create.NewCreator;
import org.directwebremoting.util.LocalUtil;
import org.directwebremoting.util.Logger;

/**
 * A Configurator that works off Annotations.
 * @author Maik Schreiber [blizzy AT blizzy DOT de]
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class AnnotationsConfigurator implements Configurator
{
    /* (non-Javadoc)
     * @see org.directwebremoting.Configurator#configure(org.directwebremoting.Container)
     */
    public void configure(Container container)
    {
        String classesStr = (String) container.getBean("classes"); //$NON-NLS-1$
        String[] classNames = classesStr.split(","); //$NON-NLS-1$
        for (int i = 0; i < classNames.length; i++)
        {
            processClass(classNames[i].trim(), container);
        }
    }

    /**
     * Process the annotations on a given class
     * @param className The class to search for annotations on
     * @param container The container to configure
     */
    private void processClass(String className, Container container)
    {
        try
        {
            Class<?> clazz = Class.forName(className);

            Script scriptAnn = clazz.getAnnotation(Script.class);
            if (scriptAnn != null)
            {
                processScript(clazz, scriptAnn, container);
            }

            Convert convertAnn = clazz.getAnnotation(Convert.class);
            if (convertAnn != null)
            {
                processConvert(clazz, convertAnn, container);
            }

            GlobalFilter globalFilterAnn = clazz.getAnnotation(GlobalFilter.class);
            if (globalFilterAnn != null)
            {
                processGlobalFilter(clazz, globalFilterAnn, container);
            }
        }
        catch (Exception ex)
        {
            log.error("Failed to process class: " + className, ex); //$NON-NLS-1$
        }
    }

    private void processScript(Class<?> clazz, Script scriptAnn, Container container)
    {
        String name = scriptAnn.name();
        Class<? extends org.directwebremoting.Creator> creator = scriptAnn.creator();
        String creatorClass = creator.getName();
        Map<String, String> creatorParams = getParamsMap(scriptAnn.creatorParams());
        ScriptScope scope = scriptAnn.scope();

        CreatorManager creatorManager = (CreatorManager) container.getBean(CreatorManager.class.getName());
        creatorManager.addCreatorType(creatorClass, creatorClass);

        Map<String, String> params = new HashMap<String, String>();
        if (NewCreator.class.isAssignableFrom(NewCreator.class))
        {
            params.put("class", clazz.getName()); //$NON-NLS-1$
        }
        params.putAll(creatorParams);
        params.put("scope", scope.getValue()); //$NON-NLS-1$

        log.info("Adding class " + clazz.getName() + " as " + name); //$NON-NLS-1$ //$NON-NLS-2$

        try
        {
            creatorManager.addCreator(name, creatorClass, params);
        }
        catch (Exception ex)
        {
            log.error("Failed to add class as Creator: " + clazz.getName(), ex); //$NON-NLS-1$
        }

        AccessControl accessControl = (AccessControl) container.getBean(AccessControl.class.getName());
        Method[] methods = clazz.getMethods();
        for (int i = 0; i < methods.length; i++)
        {
            if (methods[i].getAnnotation(RemoteMethod.class) != null)
            {
                accessControl.addIncludeRule(name, methods[i].getName());

                Auth authAnn = methods[i].getAnnotation(Auth.class);
                if (authAnn != null)
                {
                    accessControl.addRoleRestriction(name, methods[i].getName(), authAnn.role());
                }
            }
        }

        Filters filtersAnn = clazz.getAnnotation(Filters.class);
        if (filtersAnn != null)
        {
            Filter[] fs = filtersAnn.value();
            for (int i = 0; i < fs.length; i++)
            {
                processFilter(fs[i], name, container);
            }
        }
        // process single filter for convenience
        else
        {
            Filter filterAnn = clazz.getAnnotation(Filter.class);
            if (filterAnn != null)
            {
                processFilter(filterAnn, name, container);
            }
        }
    }

    private void processFilter(Filter filterAnn, String name, Container container)
    {
        Map<String, String> filterParams = getParamsMap(filterAnn.params());
        String javascript = name;
        AjaxFilter filter = (AjaxFilter) LocalUtil.classNewInstance(javascript, filterAnn.type().getName(), AjaxFilter.class);
        if (filter != null)
        {
            LocalUtil.setParams(filter, filterParams, null);
            AjaxFilterManager filterManager = (AjaxFilterManager) container.getBean(AjaxFilterManager.class.getName());
            filterManager.addAjaxFilter(filter, javascript);
        }
    }

    private void processConvert(Class<?> clazz, Convert convertAnn, Container container) throws InstantiationException, IllegalAccessException
    {
        Class<? extends org.directwebremoting.Converter> converter = convertAnn.converter();
        String converterClass = converter.getName();
        Map<String, String> params = getParamsMap(convertAnn.params());

        ConverterManager converterManager = (ConverterManager) container.getBean(ConverterManager.class.getName());
        converterManager.addConverterType(converterClass, converterClass);

        if (BeanConverter.class.isAssignableFrom(converter))
        {
            StringBuilder properties = new StringBuilder();
            Field[] fields = clazz.getFields();
            for (int i = 0; i < fields.length; i++)
            {
                if (fields[i].getAnnotation(RemoteProperty.class) != null)
                {
                    properties.append(',').append(fields[i].getName());
                }
            }

            Method[] methods = clazz.getMethods();
            for (int i = 0; i < methods.length; i++)
            {
                if (methods[i].getAnnotation(RemoteProperty.class) != null)
                {
                    String name = methods[i].getName();
                    if (name.startsWith(METHOD_PREFIX_GET) || name.startsWith(METHOD_PREFIX_IS))
                    {
                        if (name.startsWith(METHOD_PREFIX_GET))
                        {
                            name = name.substring(3);
                        }
                        else
                        {
                            name = name.substring(2);
                        }
                        name = Introspector.decapitalize(name);
                        properties.append(',').append(name);
                    }
                }
            }
            if (properties.length() > 0)
            {
                properties.deleteCharAt(0);
                params.put("include", properties.toString()); //$NON-NLS-1$
            }
        }

        converterManager.addConverter(clazz.getName(), converterClass, params);
    }

    private void processGlobalFilter(Class<?> clazz, GlobalFilter globalFilterAnn, Container container) throws InstantiationException, IllegalAccessException
    {
        if (!AjaxFilter.class.isAssignableFrom(clazz))
        {
            throw new IllegalArgumentException(clazz.getName() + " is not an AjaxFilter implementation"); //$NON-NLS-1$
        }

        Map<String, String> filterParams = getParamsMap(globalFilterAnn.params());
        AjaxFilter filter = (AjaxFilter) clazz.newInstance();
        if (filter != null)
        {
            LocalUtil.setParams(filter, filterParams, null);
            AjaxFilterManager filterManager = (AjaxFilterManager) container.getBean(AjaxFilterManager.class.getName());
            filterManager.addAjaxFilter(filter);
        }
    }

    private Map<String, String> getParamsMap(Param[] params)
    {
        Map<String, String> result = new HashMap<String, String>();
        if (params != null)
        {
            for (int i = 0; i < params.length; i++)
            {
                Param p = params[i];
                result.put(p.name(), p.value());
            }
        }
        return result;
    }

    /**
     * 
     */
    private static final String METHOD_PREFIX_IS = "is"; //$NON-NLS-1$

    /**
     * 
     */
    private static final String METHOD_PREFIX_GET = "get"; //$NON-NLS-1$

    /**
     * The log stream
     */
    private static final Logger log = Logger.getLogger(AnnotationsConfigurator.class);
}
