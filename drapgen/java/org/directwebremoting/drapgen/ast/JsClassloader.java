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
package org.directwebremoting.drapgen.ast;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class JsClassloader
{
    protected final Map<String, JsClass> sources = new HashMap<String, JsClass>();

    /**
     * @param code
     */
    public void add(JsClass code)
    {
        sources.put(code.getClassName(), code);
    }

    /**
     *
     */
    public Collection<JsClass> getClasses()
    {
        return sources.values();
    }

    /**
     *
     */
    public JsClass getClassByName(String name)
    {
        return sources.get(name);
    }
}
