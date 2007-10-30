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
package org.directwebremoting.extend;

import org.directwebremoting.dwrp.ProtocolConstants;
import org.directwebremoting.util.Messages;

/**
 * A simple struct to hold data about a single converted javascript variable.
 * An inbound variable will have either a value or a fileValue but not both. 
 * If file is <code>true</code> fileValue will be populated, otherwise value
 * will be populated.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public final class InboundVariable
{
    /**
     * Parsing ctor
     * @param context How we lookup references
     * @param key The name of the variable that this was transfered as
     * @param type The type information from javascript
     * @param value The javascript variable converted to a string
     */
    public InboundVariable(InboundContext context, String key, String type, String value)
    {
        this(context, key, type, new FormField(value));
    }

    /**
     * Parsing ctor
     * @param context How we lookup references
     * @param key The name of the variable that this was transfered as
     * @param type The type information from javascript
     * @param fileValue The javascript variable converted to a FormField
     */
    public InboundVariable(InboundContext context, String key, String type, FormField fileValue)
    {
        this.context = context;
        this.type = type;
        this.formField = fileValue;
        this.key = key;
    }

    /**
     * Attempt to de-reference an inbound variable.
     * We try de-referencing as soon as possible (why? there is a good reason
     * for it, it fixes some bug, but I can't remember what right now) However
     * the referenced variable may not exist yet, so the de-referencing may
     * fail, requiring us to have another go later.
     * @throws MarshallException If cross-references don't add up
     */
    public void dereference() throws MarshallException
    {
        int maxDepth = 0;

        while (ProtocolConstants.TYPE_REFERENCE.equals(type))
        {
            InboundVariable cd = context.getInboundVariable(formField.getString());
            if (cd == null)
            {
                throw new MarshallException(getClass(), Messages.getString("InboundVariable.MissingVariable", formField.getString()));
            }

            type = cd.getType();
            formField = cd.getFormField();

            // For some reason we used to leave this until the loop finished
            // and then only set it if the key was null. I think this logic
            // may have been broken by named objects
            key = cd.key;

            maxDepth++;
            if (maxDepth > 20)
            {
                throw new MarshallException(getClass(), "Max depth exceeded when dereferencing " + formField.getString());
            }
        }

        // For references without an explicit variable name, we use the
        // name of the thing they point at
        // if (key == null)
        // {
        //     key = formField.getString();
        // }
    }

    /**
     * @return Returns the lookup table.
     */
    public InboundContext getLookup()
    {
        return context;
    }

    /**
     * @return Returns the type.
     */
    public String getType()
    {
        return type;
    }

    /**
     * Was this type null on the way in
     * @return true if the javascript variable was null or undefined.
     */
    public boolean isNull()
    {
        return type.equals(ProtocolConstants.INBOUND_NULL);
    }

    /**
     * @return Returns the value.
     */
    public String getValue()
    {
        return formField.getString();
    }

    /**
     * @return Returns the file value
     */
    public FormField getFormField()
    {
        return formField;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return type + ProtocolConstants.INBOUND_TYPE_SEPARATOR + formField.getString(); 
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }

        if (!(obj instanceof InboundVariable))
        {
            return false;
        }

        InboundVariable that = (InboundVariable) obj;

        if (!this.type.equals(that.type))
        {
            return false;
        }

        if (!this.formField.equals(that.formField))
        {
            return false;
        }

        if (this.key == null || that.key == null)
        {
            return false;
        }

        return true; // this.key.equals(that.key);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        return formField.hashCode() + type.hashCode();
    }

    /**
     * How do be lookup references?
     */
    private InboundContext context;

    /**
     * The variable name
     */
    private String key;

    /**
     * The javascript declared variable type
     */
    private String type;

    /**
     * The javascript declared file value
     */
    private FormField formField;
}
