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

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.ListableBeanFactory;

import uk.ltd.getahead.dwr.Container;

/**
 * A <code>Container</code> implementation that looks up all beans from the
 * configuration specified in a Spring context.
 * It loads the configuration from a Spring web application context.
 * @author Bram Smeets
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class SpringContainer implements Container, BeanFactoryAware
{
    /* (non-Javadoc)
     * @see org.springframework.beans.factory.BeanFactoryAware#setBeanFactory(org.springframework.beans.factory.BeanFactory)
     */
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException
    {
        this.beanFactory = beanFactory;
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Container#getBean(java.lang.String)
     */
    public Object getBean(String id)
    {
        return beanFactory.getBean(id);
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Container#getBeanNames()
     */
    public Collection getBeanNames()
    {
        String[] list = new String[0];

        if (beanFactory instanceof ListableBeanFactory)
        {
            ListableBeanFactory listable = (ListableBeanFactory) beanFactory;
            list = listable.getBeanDefinitionNames();
        }

        return Collections.unmodifiableCollection((Arrays.asList(list)));
    }

    /**
     * The Spring BeanFactory that we read from
     */
    private BeanFactory beanFactory;
}
