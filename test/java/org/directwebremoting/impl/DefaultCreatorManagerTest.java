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

import org.directwebremoting.create.NewCreator;
import org.directwebremoting.extend.Creator;
import org.junit.Test;

/**
 * @author Bram Smeets
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class DefaultCreatorManagerTest
{
    private DefaultCreatorManager manager = new DefaultCreatorManager();

    @Test(expected = NullPointerException.class)
    public void addCreatorTypeNull()
    {
        manager.addCreatorType(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addCreatorTypeFail()
    {
        manager.addCreatorType(null, this.getClass().getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addCreatorTypeFail2()
    {
        manager.addCreatorType(null, Creator.class.getName());
    }

    @Test
    public void addCreatorType()
    {
        manager.addCreatorType(null, NewCreator.class.getName());
    }

    @Test
    public void addCreator()
    {
        NewCreator creator = new NewCreator();
        manager.addCreator(null, creator);
    }
}
