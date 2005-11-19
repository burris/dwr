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

import static org.easymock.EasyMock.*;
import junit.framework.TestCase;

import uk.ltd.getahead.dwr.*;

import java.util.Map;
import java.lang.reflect.Method;

/**
 * @author Bram Smeets
 */
public class DefaultConfigurationTests extends TestCase {
    private DefaultConfiguration config = new DefaultConfiguration();

    private AjaxFilterManager ajaxFilterManager;
    private CreatorManager creatorManager;
    private AccessControl accessControl;
    private ConverterManager converterManager;

    protected void setUp() throws Exception {
        ajaxFilterManager = createMock(AjaxFilterManager.class);
        config.setAjaxFilterManager(ajaxFilterManager);

        creatorManager = createMock(CreatorManager.class);
        config.setCreatorManager(creatorManager);

        accessControl = createMock(AccessControl.class);
        config.setAccessControl(accessControl);

        converterManager = createMock(ConverterManager.class);
        config.setConverterManager(converterManager);
    }

    public void test() throws Exception {
        ajaxFilterManager.addAjaxFilter((AjaxFilter)isA(AjaxFilter.class));
        expectLastCall().atLeastOnce();
        ajaxFilterManager.addAjaxFilter((AjaxFilter)isA(AjaxFilter.class), (String)isA(String.class));
        expectLastCall().atLeastOnce();
        creatorManager.addCreator((String)isA(String.class), (String)isA(String.class), (Map)isA(Map.class));
        expectLastCall().atLeastOnce();
        accessControl.addExcludeRule((String)isA(String.class), (String)isA(String.class));
        expectLastCall().atLeastOnce();
        accessControl.addRoleRestriction((String)isA(String.class), (String)isA(String.class), (String)isA(String.class));
        expectLastCall().atLeastOnce();
        converterManager.addConverterType((String)isA(String.class), (Class)isA(Class.class));
        converterManager.addConverter((String)isA(String.class), (String)isA(String.class), (Map)isA(Map.class));
        expectLastCall().atLeastOnce();
        converterManager.setExtraTypeInfo((Method)isA(Method.class), eq(0), geq(0), (Class)isA(Class.class));
        expectLastCall().atLeastOnce();

        replay(ajaxFilterManager);
        replay(creatorManager);
        replay(converterManager);
        replay(accessControl);

        config.addConfig(getClass().getResourceAsStream("dwr.xml"));

        verify(ajaxFilterManager);
        verify(creatorManager);
        verify(converterManager);
        verify(accessControl);
    }
}