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
package org.directwebremoting;

import org.directwebremoting.convert.AllConverterTest;
import org.directwebremoting.convert.BeanConverterTest;
import org.directwebremoting.convert.ConstructorConverterTest;
import org.directwebremoting.convert.DateConverterTest;
import org.directwebremoting.convert.ObjectConverterTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
@RunWith(Suite.class)
@SuiteClasses({
    AllConverterTest.class,
    BeanConverterTest.class,
    ConstructorConverterTest.class,
    DateConverterTest.class,
    ObjectConverterTest.class
})
public class AllTests
{
}
