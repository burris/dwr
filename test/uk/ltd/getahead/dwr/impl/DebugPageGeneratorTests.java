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

import java.lang.reflect.Method;
import java.util.ArrayList;

import junit.framework.TestCase;

import org.easymock.EasyMock;

import uk.ltd.getahead.dwr.AccessControl;
import uk.ltd.getahead.dwr.Creator;
import uk.ltd.getahead.dwr.CreatorManager;
import uk.ltd.getahead.dwr.HttpResponse;
import uk.ltd.getahead.dwr.create.NewCreator;
import uk.ltd.getahead.dwr.dwrp.ConverterManager;
import uk.ltd.getahead.dwr.impl.test.TestCreatedObject;

/**
 * @author
 */
public class DebugPageGeneratorTests extends TestCase
{
    private DefaultDebugPageGenerator debugPageGenerator = new DefaultDebugPageGenerator();

    private CreatorManager creatorManager;

    private AccessControl accessControl;

    private ConverterManager converterManager;

    protected void setUp() throws Exception
    {
        super.setUp();

        creatorManager = (CreatorManager) EasyMock.createMock(CreatorManager.class);
        debugPageGenerator.setCreatorManager(creatorManager);

        accessControl = (AccessControl) EasyMock.createMock(AccessControl.class);
        debugPageGenerator.setAccessControl(accessControl);

        converterManager = (ConverterManager) EasyMock.createMock(ConverterManager.class);
        debugPageGenerator.setConverterManager(converterManager);
    }

    /**
     * @throws Exception
     */
    public void testHandleInNonDebug() throws Exception
    {
        creatorManager.isDebug();
        EasyMock.expectLastCall().andReturn(Boolean.FALSE);

        EasyMock.replay(creatorManager);
        EasyMock.replay(accessControl);
        EasyMock.replay(converterManager);

        HttpResponse response = null;
        try {
            response = debugPageGenerator.generateIndexPage("/");
            fail("a security exception was expected");
        } catch (SecurityException e) {
            // do nothing, was expected
        }

        EasyMock.verify(creatorManager);
        EasyMock.verify(accessControl);
        EasyMock.verify(converterManager);

        assertNull(response);
//        assertTrue(new String(response.getBody()).indexOf("Test Pages") != -1);
    }

    /**
     * @throws Exception
     */
    public void testHandle() throws Exception
    {
        creatorManager.isDebug();
        EasyMock.expectLastCall().andReturn(Boolean.TRUE);

        creatorManager.getCreator("creatorName");
        NewCreator creator = new NewCreator();
        creator.setClass(TestCreatedObject.class.getName());
        EasyMock.expectLastCall().andReturn(creator);

        EasyMock.expect(accessControl.getReasonToNotDisplay((Creator) EasyMock.eq(creator), (String) EasyMock.eq("creatorName"), (Method) EasyMock.isA(Method.class)));
        EasyMock.expectLastCall().andReturn(null).times(11);

        converterManager.isConvertable((Class) EasyMock.anyObject());
        EasyMock.expectLastCall().andReturn(Boolean.TRUE).times(19);

        EasyMock.expect(accessControl.getReasonToNotExecute((Creator) EasyMock.eq(creator), (String) EasyMock.eq("creatorName"), (Method) EasyMock.isA(Method.class)));
        EasyMock.expectLastCall().andReturn(null).times(10);

        EasyMock.replay(creatorManager);
        EasyMock.replay(accessControl);
        EasyMock.replay(converterManager);

        HttpResponse response = debugPageGenerator.generateTestPage("", "creatorName");

        EasyMock.verify(creatorManager);
        EasyMock.verify(accessControl);
        EasyMock.verify(converterManager);

        String result = new String(response.getBody());

        assertNotNull(result);
        assertTrue(result.indexOf("testMethodWithServletParameters(") != -1);
        assertTrue(result.indexOf("hashCode(") != -1);
        assertTrue(result.indexOf("getClass(") != -1);
        assertTrue(result.indexOf("wait(") != -1);
        assertTrue(result.indexOf("equals(") != -1);
        assertTrue(result.indexOf("notify(") != -1);
        assertTrue(result.indexOf("notifyAll(") != -1);
        assertTrue(result.indexOf("toString(") != -1);
    }

    /**
     * @throws Exception
     */
    public void testHandleWithoutDebug() throws Exception
    {
        creatorManager.isDebug();
        EasyMock.expectLastCall().andReturn(Boolean.FALSE);

        EasyMock.replay(creatorManager);

        try
        {
            debugPageGenerator.generateIndexPage("root");
            fail("Missing SecurityException");
        }
        catch (SecurityException ex)
        {
        }

        EasyMock.verify(creatorManager);
    }

    /**
     * @throws Exception
     */
    public void testGenerateIndexPage() throws Exception
    {
        creatorManager.isDebug();
        EasyMock.expectLastCall().andReturn(Boolean.TRUE);

        creatorManager.getCreatorNames();
        ArrayList names = new ArrayList();
        names.add("creatorName");
        EasyMock.expectLastCall().andReturn(names);

        creatorManager.getCreator("creatorName");
        NewCreator creator = new NewCreator();
        creator.setClass(TestCreatedObject.class.getName());
        EasyMock.expectLastCall().andReturn(creator);

        EasyMock.replay(creatorManager);

        HttpResponse result = debugPageGenerator.generateIndexPage("root");

        EasyMock.verify(creatorManager);

        assertNotNull(result);
        assertTrue(new String(result.getBody()).indexOf("creatorName") != -1);
        assertTrue(new String(result.getBody()).indexOf(TestCreatedObject.class.getName()) != -1);
    }
}
