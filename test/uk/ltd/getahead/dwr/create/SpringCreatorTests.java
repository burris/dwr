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

package uk.ltd.getahead.dwr.create;

import junit.framework.TestCase;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.support.StaticApplicationContext;
import uk.ltd.getahead.dwr.create.test.DummyDataManager;
import uk.ltd.getahead.dwr.Creator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bram Smeets
 */
public class SpringCreatorTests extends TestCase {
    private SpringCreator creator;

    protected void setUp() throws Exception {
        super.setUp();

        creator = new SpringCreator();

        Map params = new HashMap();
        params.put("location", "/uk/ltd/getahead/dwr/create/spring-beans.xml");
        creator.setProperties(params);

        creator.setBeanName("dataManager");
    }

    public void testBeanName() {
        String beanName = "beanName";
        creator.setBeanName(beanName);
        assertEquals(beanName, creator.getBeanName());
    }

    public void testGetScope() {
        // make sure the default scope is the PAGE scope
        assertEquals(Creator.PAGE, creator.getScope());
    }

    public void testGetType() {
        assertEquals(DummyDataManager.class, creator.getType());
    }

    public void testGetInstance() throws Exception {
        DummyDataManager mgr = (DummyDataManager) creator.getInstance();
        assertEquals(new DummyDataManager(), mgr);
    }

    public void testNonExistingBean() throws Exception {
        creator.setBeanName("nonExistingBean");
        try {
            creator.getInstance();
            fail("a no such bean definition exception was expected");
        } catch (NoSuchBeanDefinitionException e) {
            // do nothing, was expected
        }
    }

    public void testOverrideBeanFactory() throws Exception {
        StaticApplicationContext ctx = new StaticApplicationContext();
        ctx.registerSingleton("dataManager", DummyDataManager.class);
        SpringCreator.setOverrideBeanFactory(ctx);

        assertEquals(DummyDataManager.class, creator.getType());

        DummyDataManager mgr = (DummyDataManager) creator.getInstance();
        assertEquals(new DummyDataManager(), mgr);

        SpringCreator.setOverrideBeanFactory(null);
    }

    public void testWithoutBeanNameWithRequest() throws Exception {
        SpringCreator creator2 = new SpringCreator();
        creator2.setBeanName("dataManager");

        // TODO: have the spring creator return instatiation exception
        try {
            creator2.getInstance();
            fail("a null pointer exception was expected");
        } catch(NullPointerException e) {
            // do nothing, was expected
        }
    }

    public void testWithoutBeanNameWithoutRequest() throws Exception {
        SpringCreator creator2 = new SpringCreator();
        creator2.setBeanName("dataManager");

        // TODO: have the spring creator return instatiation exception
        try {
            creator2.getInstance();
            fail("a null pointer exception was expected");
        } catch(NullPointerException e) {
            // do nothing, was expected
        }
    }

    public void testSetClass() throws Exception {
        SpringCreator creator2 = new SpringCreator();

        try {
            creator2.setClass("NonExistingClass");
            fail("an illegal argument exception was expected");
        } catch (IllegalArgumentException e) {
            // do nothing, was expected
        }

        creator2.setClass(getClass().getName());
    }
}