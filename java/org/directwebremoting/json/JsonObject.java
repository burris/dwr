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
package org.directwebremoting.json;

import java.util.Map;
import java.util.Set;

import org.directwebremoting.util.JavascriptUtil;

/**
 * In official JSON parlance this should be called Object, however this would
 * cause confusion with {@link java.lang.Object} which is auto-imported.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class JsonObject
{
    /**
     * @see java.util.Map#clear()
     */
    public void clear()
    {
        proxy.clear();
    }

    /**
     * @see java.util.Map#isEmpty()
     */
    public boolean isEmpty()
    {
        return proxy.isEmpty();
    }

    /**
     * @see java.util.Map#size()
     */
    public int size()
    {
        return proxy.size();
    }

    /**
     * @see java.util.Map#containsKey(java.lang.Object)
     */
    public boolean containsKey(String key)
    {
        return proxy.containsKey(key);
    }

    /**
     * 
     */
    public JsonObject getJsonObject(String key)
    {
        return (JsonObject) proxy.get(key);
    }

    /**
     * 
     */
    public JsonArray getJsonArray(String key)
    {
        return (JsonArray) proxy.get(key);
    }

    /**
     * 
     */
    public String getString(String key)
    {
        return (String) proxy.get(key);
    }

    /**
     * 
     */
    public Integer getInteger(String key)
    {
        return (Integer) proxy.get(key);
    }

    /**
     * 
     */
    public Long getLong(String key)
    {
        return (Long) proxy.get(key);
    }

    /**
     * 
     */
    public Double getDouble(String key)
    {
        return (Double) proxy.get(key);
    }

    /**
     * @see java.util.Map#keySet()
     */
    public Set<String> keySet()
    {
        return proxy.keySet();
    }

    /**
     * @see java.util.Map#put(java.lang.Object, java.lang.Object)
     */
    public void put(String key, JsonObject value)
    {
        proxy.put(key, value);
    }

    /**
     * @see java.util.Map#put(java.lang.Object, java.lang.Object)
     */
    public void put(String key, JsonArray value)
    {
        proxy.put(key, value);
    }

    /**
     * @see java.util.Map#put(java.lang.Object, java.lang.Object)
     */
    public void put(String key, String value)
    {
        proxy.put(key, value);
    }

    /**
     * @see java.util.Map#put(java.lang.Object, java.lang.Object)
     */
    public void put(String key, Integer value)
    {
        proxy.put(key, value);
    }

    /**
     * @see java.util.Map#put(java.lang.Object, java.lang.Object)
     */
    public void put(String key, Long value)
    {
        proxy.put(key, value);
    }

    /**
     * @see java.util.Map#put(java.lang.Object, java.lang.Object)
     */
    public void put(String key, Double value)
    {
        proxy.put(key, value);
    }

    /**
     * @see java.util.Map#remove(java.lang.Object)
     */
    public void remove(String key)
    {
        proxy.remove(key);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        StringBuffer output = new StringBuffer();
        output.append("{ ");

        boolean isFirst = true;
        for (Map.Entry<String, Object> entry : proxy.entrySet())
        {
            if (isFirst)
            {
                isFirst = false;
            }
            else
            {
                output.append(", ");
            }

            output.append("'");
            output.append(entry.getKey());
            output.append("'");
            output.append(":");

            Object value = entry.getValue();
            if (value instanceof String)
            {
                output.append("'");
                output.append(JavascriptUtil.escapeJavaScript((String) value));
                output.append("'");
            }
            else
            {
                output.append(value.toString());
            }
            output.append(":");
        }
        output.append(" }");
        return super.toString();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o)
    {
        return proxy.equals(o);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        return proxy.hashCode();
    }

    private Map<String, Object> proxy;
}
