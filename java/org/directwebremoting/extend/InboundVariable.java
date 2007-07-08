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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
        this (context, key, type, new FormField(value));
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
        this.file = true;
        this.dereferenced = attemptDereference();
    }
    
    /**
     * Attempt to de-reference an inbound variable.
     * We try de-referencing as soon as possible (why? there is a good reason
     * for it, it fixes some bug, but I can't remember what right now) However
     * the referenced variable may not exist yet, so the de-referencing may
     * fail, requiring us to have another go later.
     * @return Did the dereferencing succeed?
     */
    private boolean attemptDereference()
    {
        int maxDepth = 0;

        if (ProtocolConstants.TYPE_REFERENCE.equals(type))
        {
            while (ProtocolConstants.TYPE_REFERENCE.equals(type))
            {
                InboundVariable cd = context.getInboundVariable(formField.getString());
                if (cd == null)
                {
                    return false;
                }

                type = cd.getType();
                file = cd.isFile();
                formField = cd.getFormField();

                maxDepth++;
                if (maxDepth > 20)
                {
                    throw new IllegalStateException("Max depth exceeded when dereferencing " + formField.getString());
                }
            }

            // For references without an explicit variable name, we use the
            // name of the thing they point at
            if (key == null)
            {
                key = formField.getString();
            }
        }

        return true;
    }

    /**
     * Call <code>attemptDereference()</code>, and complain if it fails.
     * The assumption is that when we call this it really should succeed.
     */
    private void forceDereference()
    {
        if (!dereferenced)
        {
            dereferenced = attemptDereference();
            if (!dereferenced)
            {
                log.error(Messages.getString("InboundVariable.MissingVariable", formField.getString()));
            }
        }
    }

    /**
     * @return Returns the lookup table.
     */
    public InboundContext getLookup()
    {
        forceDereference();
        return context;
    }

    /**
     * @return Returns the type.
     */
    public String getType()
    {
        forceDereference();
        return type;
    }

    /**
     * Was this type null on the way in
     * @return true if the javascript variable was null or undefined.
     */
    public boolean isNull()
    {
        forceDereference();
        return type.equals(ProtocolConstants.INBOUND_NULL);
    }

    /**
     * @return Returns the value.
     */
    public String getValue()
    {
        forceDereference();
        return formField.getString();
    }
    
    /**
     * @return Returns the file value
     */
    public FormField getFormField()
    {
        return formField;
    }
    
    /**
     * Does this inbound variable represent a file?
     */
    public boolean isFile()
    {
        return file;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        forceDereference();
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

        forceDereference();

        if (!this.type.equals(that.type))
        {
            return false;
        }

        if (!this.file == that.file) 
        {
            return false;
        }
        
        if (!this.formField.equals(that.formField)) {
            return false;
        }

        if (this.key == null || that.key == null)
        {
            return false;
        }

        return this.key.equals(that.key);
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

    /**
     * Has this variable been successfully de-referenced
     */
    private boolean dereferenced;
    
    /**
     * Does this inbound variable represent a file?
     */
    private boolean file;

    /**
     * The log stream
     */
    private static final Log log = LogFactory.getLog(InboundVariable.class);
}
