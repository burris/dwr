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

import java.util.List;

import org.directwebremoting.util.JavascriptUtil;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class JsonArray
{
    /**
     * @see java.util.List#size()
     */
    public int size()
    {
        return proxy.size();
    }

    /**
     * @see java.util.List#clear()
     */
    public void clear()
    {
        proxy.clear();
    }

    /**
     */
    public boolean isEmpty()
    {
        return proxy.isEmpty();
    }

    /**
     * @see java.util.List#contains(java.lang.Object)
     */
    public boolean contains(JsonObject o)
    {
        return proxy.contains(o);
    }

    /**
     * @see java.util.List#get(int)
     */
    public JsonObject getJsonObject(int index)
    {
        return (JsonObject) proxy.get(index);
    }

    /**
     * @see java.util.List#get(int)
     */
    public JsonArray getJsonArray(int index)
    {
        return (JsonArray) proxy.get(index);
    }

    /**
     * @see java.util.List#get(int)
     */
    public String getString(int index)
    {
        return (String) proxy.get(index);
    }

    /**
     * @see java.util.List#get(int)
     */
    public Integer getInteger(int index)
    {
        return (Integer) proxy.get(index);
    }

    /**
     * @see java.util.List#get(int)
     */
    public Long getLong(int index)
    {
        return (Long) proxy.get(index);
    }

    /**
     * @see java.util.List#get(int)
     */
    public Double getDouble(int index)
    {
        return (Double) proxy.get(index);
    }

    /**
     * @see java.util.List#add(java.lang.Object)
     */
    public void add(JsonObject o)
    {
        proxy.add(o);
    }

    /**
     * @see java.util.List#add(java.lang.Object)
     */
    public void add(JsonArray o)
    {
        proxy.add(o);
    }

    /**
     * @see java.util.List#add(java.lang.Object)
     */
    public void add(String o)
    {
        proxy.add(o);
    }

    /**
     * @see java.util.List#add(java.lang.Object)
     */
    public void add(Integer o)
    {
        proxy.add(o);
    }

    /**
     * @see java.util.List#add(java.lang.Object)
     */
    public void add(Long o)
    {
        proxy.add(o);
    }

    /**
     * @see java.util.List#add(java.lang.Object)
     */
    public void add(Double o)
    {
        proxy.add(o);
    }

    /**
     * @see java.util.List#set(int, java.lang.Object)
     */
    public void set(int index, JsonArray element)
    {
        proxy.set(index, element);
    }

    /**
     * @see java.util.List#set(int, java.lang.Object)
     */
    public void set(int index, String element)
    {
        proxy.set(index, element);
    }

    /**
     * @see java.util.List#set(int, java.lang.Object)
     */
    public void set(int index, Integer element)
    {
        proxy.set(index, element);
    }

    /**
     * @see java.util.List#set(int, java.lang.Object)
     */
    public void set(int index, Long element)
    {
        proxy.set(index, element);
    }

    /**
     * @see java.util.List#set(int, java.lang.Object)
     */
    public void set(int index, Double element)
    {
        proxy.set(index, element);
    }

    /**
     * @see java.util.List#contains(java.lang.Object)
     */
    public boolean contains(JsonArray o)
    {
        return proxy.contains(o);
    }

    /**
     * @see java.util.List#contains(java.lang.Object)
     */
    public boolean contains(String o)
    {
        return proxy.contains(o);
    }

    /**
     * @see java.util.List#contains(java.lang.Object)
     */
    public boolean contains(Integer o)
    {
        return proxy.contains(o);
    }

    /**
     * @see java.util.List#contains(java.lang.Object)
     */
    public boolean contains(Long o)
    {
        return proxy.contains(o);
    }

    /**
     * @see java.util.List#contains(java.lang.Object)
     */
    public boolean contains(Double o)
    {
        return proxy.contains(o);
    }

    /**
     * @see java.util.List#remove(int)
     */
    public void remove(int index)
    {
        proxy.remove(index);
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
        for (Object value : proxy)
        {
            if (isFirst)
            {
                isFirst = false;
            }
            else
            {
                output.append(", ");
            }

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
        return output.toString();
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

    private List<Object> proxy;
}

