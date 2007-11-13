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
package org.directwebremoting.proxy.jsx3.gui;


/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public interface Form
{

    /**
     * #a8a8b5 (default)
     */
    public static final String DEFAULTDISABLEDCOLOR = "#a8a8b5";

    /**
     * #d8d8e5 (default)
     */
    public static final String DEFAULTDISABLEDBACKGROUNDCOLOR = "#d8d8e5";

    /**
     * Value for the validation state field indicating that the value of the form field is invalid.
     */
    public static final int STATEINVALID = 0;

    /**
     * Value for the validation state field indicating that the value of the form field is valid.
     */
    public static final int STATEVALID = 1;

    /**
     * Value for the enabled field indicating that the form field is disabled.
     */
    public static final int STATEDISABLED = 0;

    /**
     * Value for the enabled field indicating that the form field is enabled.
     */
    public static final int STATEENABLED = 1;

    /**
     * Value for the required field indicating that the form field is optional.
     */
    public static final int OPTIONAL = 0;

    /**
     * Value for the required field indicating that the form field is required.
     */
    public static final int REQUIRED = 1;

}
