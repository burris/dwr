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
import uk.ltd.getahead.dwr.Creator;
import uk.ltd.getahead.dwr.create.NewCreator;

/**
 * @author Bram Smeets
 */
public class DefaultCreatorManagerTests extends TestCase {
    private DefaultCreatorManager manager = new DefaultCreatorManager();

    public void testAddCreatorType() {
        try {
            manager.addCreatorType(null, null);
            fail("a null pointer exception was expected");
        } catch (NullPointerException e) {
            // do nothing, was expected
        }

        try {
            manager.addCreatorType(null, this.getClass());
            fail("an illegal argument exception was expected");
        } catch (IllegalArgumentException e) {
            // do nothing, was expected
        }

        try {
            manager.addCreatorType(null, Creator.class);
            fail("an illegal argument exception was expected");
        } catch (IllegalArgumentException e) {
            // do nothing, was expected
        }

        manager.addCreatorType(null, NewCreator.class);
    }

    public void testAddCreator() {
        NewCreator creator = new NewCreator();
        manager.addCreator(null, creator);
    }
}