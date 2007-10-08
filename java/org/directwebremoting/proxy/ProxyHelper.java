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
package org.directwebremoting.proxy;

import org.directwebremoting.io.Context;

/**
 * A class to help automatically generated proxy objects.
 * It is likely that all proxy objects will contain a {@link ProxyHelper}
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class ProxyHelper
{
    /**
     * Create a new {@link ProxyHelper}
     * @param proxy A destination for the generated scripts
     * @param context A base for Javascript commands
     */
    public ProxyHelper(ScriptProxy proxy, Context context)
    {
        this.scriptProxy = proxy;
        this.context = context;
    }

    /**
     * Accessor for the current script proxy
     * @return The current script proxy
     */
    public ScriptProxy getScriptProxy()
    {
        return scriptProxy;
    }

    /**
     * Accessor for the current context
     * @return The current context
     */
    public Context getContext()
    {
        return context;
    }

    /**
     * Create a child with a new context with the given extension
     * @param extension The leaf to add to the Context
     * @return A new child {@link ProxyHelper}
     */
    public ProxyHelper getChildHelper(String extension)
    {
        return new ProxyHelper(scriptProxy, new Context(context, extension));
    }

    /**
     * A string with which to prefix a proxy object, so it has something to act on
     */
    private Context context;

    /**
     * A destination for the generated scripts
     */
    private ScriptProxy scriptProxy;
}
