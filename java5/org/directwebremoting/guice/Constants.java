/*
 * Copyright 2007 Tim Peierls
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
package org.directwebremoting.guice;


/**
 * Constants for DWR-Guice integration
 * @author Tim Peierls [tim at peierls dot net]
 */
class Constants {

    static final String INIT_DEBUG = "debug";

    static final String INIT_CLASSES = "classes";

    static final String PREFIX = "org.directwebremoting.guice.Constants.";

    static final String DEBUG = PREFIX + INIT_DEBUG;

    static final String CLASSES = PREFIX + INIT_CLASSES;

    private Constants() { /* uninstantiable */ }
}
