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

import java.lang.reflect.Method;

import junit.framework.TestCase;

import org.directwebremoting.WebContextFactory;
import org.directwebremoting.WebContextFactory.WebContextBuilder;
import org.directwebremoting.create.NewCreator;
import org.directwebremoting.extend.Creator;
import org.directwebremoting.impl.DefaultAccessControl;
import org.directwebremoting.impl.DefaultWebContextBuilder;
import org.directwebremoting.util.Messages;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

/**
 * @author Bram Smeets
 */
public class DefaultAccessControlTests extends TestCase
{
    private DefaultAccessControl accessControl = new DefaultAccessControl();

    private MockHttpServletRequest request;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();

        request = new MockHttpServletRequest();
    }

    /**
     * @throws Exception
     */
    public void testReasonToNotDisplayDwrObject() throws Exception
    {
        NewCreator creator = new NewCreator();
        creator.setClass("org.directwebremoting.ExecutionContext");

        try
        {
            accessControl.assertIsDisplayable(creator, "", getMethod());
            fail();
        }
        catch (SecurityException ex)
        {
            assertEquals(Messages.getString("ExecuteQuery.DeniedCoreDWR"), ex.getMessage());
        }
    }

    /**
     * @throws Exception
     */
    public void testReasonToNotDisplay() throws Exception
    {
        NewCreator creator = new NewCreator();
        creator.setClass("java.lang.Object");

        accessControl.assertIsDisplayable(creator, "", getMethod());
    }

    /**
     * @throws Exception
     */
    public void testReasonToNotDisplayWithNonPublicMethod() throws Exception
    {
        try
        {
            accessControl.assertIsDisplayable(null, null, getPrivateMethod());
            fail();
        }
        catch (SecurityException ex)
        {
            assertNotNull(ex.getMessage());
        }
    }

    /**
     * @throws Exception
     */
    public void testReasonToNotDisplayWithNonExecutableMethod() throws Exception
    {
        accessControl.addExcludeRule("className", "someMethod");

        try
        {
            accessControl.assertIsDisplayable(null, "className", getMethod());
            fail();
        }
        catch (SecurityException ex)
        {
            assertNotNull(ex.getMessage());
        }
    }

    /**
     * @throws Exception
     */
    public void testReasonToNotDisplayWithMethodWithDwrParameter() throws Exception
    {
        NewCreator creator = new NewCreator();
        creator.setClass("java.lang.Object");

        try
        {
            accessControl.assertIsDisplayable(creator, "className", getMethodWithDwrParameter());
            fail();
        }
        catch (SecurityException ex)
        {
            assertNotNull(ex.getMessage());
        }
    }

    /**
     * @throws Exception
     */
    public void testReasonToNotDisplayWithObjectMethod() throws Exception
    {
        NewCreator creator = new NewCreator();
        creator.setClass("java.lang.Object");

        try
        {
            accessControl.assertIsDisplayable(creator, "className", getHashCodeMethod());
            fail();
        }
        catch (SecurityException ex)
        {
            assertNotNull(ex.getMessage());
        }
    }

    /**
     * @throws Exception
     */
    public void testReasonToNotExecute() throws Exception
    {
        WebContextBuilder builder = new DefaultWebContextBuilder();
        builder.set(new MockHttpServletRequest(), new MockHttpServletResponse(), null, null, null);
        WebContextFactory.setWebContextBuilder(builder);

        NewCreator creator = new NewCreator();

        try
        {
            accessControl.assertExecutionIsPossible(creator, "className", getMethod());
            fail();
        }
        catch (SecurityException ex)
        {
            assertNotNull(ex.getMessage());
        }

        accessControl.addRoleRestriction("className", "someMethod", "someRole");
        accessControl.addRoleRestriction("className", "someMethod", "someOtherRole");

        try
        {
            accessControl.assertExecutionIsPossible(creator, "className", getMethod());
            fail();
        }
        catch (SecurityException ex)
        {
            assertNotNull(ex.getMessage());
        }

        request.addUserRole("someRole");

        try
        {
            accessControl.assertExecutionIsPossible(creator, "className", getMethod());
            fail();
        }
        catch (SecurityException ex)
        {
            assertNotNull(ex.getMessage());
        }
    }

    /**
     * 
     */
    public void someMethod()
    {
        // do nothing
    }

    /**
     * @param someString
     * @param creator
     */
    public void someMethodWithDwrParameter(String someString, Creator creator)
    {
        Object ignore = someString;
        ignore =  creator;
        creator = (Creator) ignore;

        // do nothing
    }

    /**
     * 
     */
    private void somePrivateMethod()
    {
        // do nothing
    }

    private Method getMethod() throws NoSuchMethodException
    {
        return getClass().getMethod("someMethod", new Class[0]);
    }

    private Method getMethodWithDwrParameter() throws NoSuchMethodException
    {
        return getClass().getMethod("someMethodWithDwrParameter", new Class[]
        {
            String.class, Creator.class
        });
    }

    private Method getPrivateMethod() throws NoSuchMethodException
    {
        return getClass().getDeclaredMethod("somePrivateMethod", new Class[0]);
    }

    private Method getHashCodeMethod() throws NoSuchMethodException
    {
        return getClass().getMethod("hashCode", new Class[0]);
    }

    /**
     * Shuts lint up
     */
    protected void ignore()
    {
        somePrivateMethod();
    }
}
