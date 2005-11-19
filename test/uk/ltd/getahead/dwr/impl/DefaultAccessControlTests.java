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

package uk.ltd.getahead.dwr.impl;

import junit.framework.TestCase;
import org.springframework.mock.web.MockHttpServletRequest;

import java.lang.reflect.Method;

import uk.ltd.getahead.dwr.create.NewCreator;
import uk.ltd.getahead.dwr.Messages;
import uk.ltd.getahead.dwr.Creator;

/**
 * @author Bram Smeets
 */
public class DefaultAccessControlTests extends TestCase {

    private DefaultAccessControl accessControl = new DefaultAccessControl();

    private MockHttpServletRequest request;

    protected void setUp() throws Exception {
        super.setUp();

        request = new MockHttpServletRequest();
    }

    public void testReasonToNotDisplayDwrObject() throws Exception {
        NewCreator creator = new NewCreator();
        creator.setClass("uk.ltd.getahead.dwr.Messages");

        String result = accessControl.getReasonToNotDisplay(request, creator, "", getMethod());
        assertEquals(Messages.getString("ExecuteQuery.DeniedCoreDWR"), result);
    }

    public void testReasonToNotDisplay() throws Exception {
        NewCreator creator = new NewCreator();
        creator.setClass("java.lang.Object");

        String result = accessControl.getReasonToNotDisplay(request, creator, "", getMethod());
        assertNull(result);
    }

    public void testReasonToNotDisplayWithNonPublicMethod() throws Exception {
        String result = accessControl.getReasonToNotDisplay(request, null, null, getPrivateMethod());
        assertNotNull(result);
    }

    public void testReasonToNotDisplayWithNonExecutableMethod() throws Exception {
        accessControl.addExcludeRule("className", "someMethod");

        String result = accessControl.getReasonToNotDisplay(request, null, "className", getMethod());
        assertNotNull(result);
    }

    public void testReasonToNotDisplayWithMethodWithDwrParameter() throws Exception {
        NewCreator creator = new NewCreator();
        creator.setClass("java.lang.Object");

        String result = accessControl.getReasonToNotDisplay(request, creator, "className", getMethodWithDwrParameter());
        assertNotNull(result);
    }

    public void testReasonToNotDisplayWithObjectMethod() throws Exception {
        NewCreator creator = new NewCreator();
        creator.setClass("java.lang.Object");

        String result = accessControl.getReasonToNotDisplay(request, creator, "className", getHashCodeMethod());
        assertNotNull(result);
    }

    public void testReasonToNotExecute() throws Exception {
        NewCreator creator = new NewCreator();

        String result = accessControl.getReasonToNotExecute(request, creator, "className", getMethod());
        assertNull(result);

        accessControl.addRoleRestriction("className", "someMethod", "someRole");
        accessControl.addRoleRestriction("className", "someMethod", "someOtherRole");
        result = accessControl.getReasonToNotExecute(request, creator, "className", getMethod());
        assertNotNull(result);

        request.addUserRole("someRole");
        result = accessControl.getReasonToNotExecute(request, creator, "className", getMethod());
        assertNull(result);
    }

    public void someMethod() {
        // do nothing
    }

    public void someMethodWithDwrParameter(String someString, Creator creator) {
        // do nothing
    }

    private void somePrivateMethod() {
        // do nothing
    }

    private Method getMethod() throws NoSuchMethodException {
        return getClass().getMethod("someMethod", new Class[0]);
    }

    private Method getMethodWithDwrParameter() throws NoSuchMethodException {
        return getClass().getMethod("someMethodWithDwrParameter", new Class[] { String.class, Creator.class });
    }

    private Method getPrivateMethod() throws NoSuchMethodException {
        return getClass().getDeclaredMethod("somePrivateMethod", new Class[0]);
    }

    private Method getHashCodeMethod() throws NoSuchMethodException {
        return getClass().getMethod("hashCode", new Class[0]);
    }
}