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
package org.directwebremoting.proxy.jsx3.xml;

import java.lang.reflect.Constructor;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public interface Cacheable
{
    
    /**
     * JSX/xsl/xml.xsl
     */
    public static final String DEFAULTSTYLESHEET = null;

    /**
     * Value of the shareResources property for an object that removes its XML and XSL
  documents from the server XML cache when it is destroyed.
     */
    public static final int CLEANUPRESOURCES = 0;

    /**
     * Value of the shareResources property for an object that leaves its XML and XSL
  documents in the server XML cache when it is destroyed.
     */
    public static final int SHARERESOURCES = 1;


}
