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
package org.getahead.dwrdemo.proxy.gi;

import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class Server
{
    /**
     * @param helper
     */
    public Server(ProxyHelper helper)
    {
        this.helper = helper;
    }

    /**
     * @param jsxid The JSXID of the model element that we are using
     * @param type The expected type of the model element
     * @return A class of the expected type
     */
    @SuppressWarnings("unchecked")
    public <T> T getJsxById(String jsxid, Class<T> type)
    {
        ProxyHelper child = helper.getChildHelper(".getJSXById(\"" + jsxid + "\")");
        if (type == Button.class)
        {
            return (T) new Button(child);
        }
        else
        {
            throw new IllegalArgumentException("Unsupported type: " + type.getName());
        }
    }

    private ProxyHelper helper;
}
