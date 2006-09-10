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
package org.directwebremoting;

import org.directwebremoting.util.Logger;

/**
 * A simple data container for 2 strings that comprise information about how a
 * Java object has been converted into Javascript.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public final class OutboundVariable
{
    /**
     * Default ctor that leaves blank (not null) members
     */
    public OutboundVariable()
    {
    }

    /**
     * Default ctor that leaves blank (not null) members
     * @param initCode the init script
     * @param assignCode the access for the inited code
     */
    public OutboundVariable(String initCode, String assignCode)
    {
        this.initCode = initCode;
        this.assignCode = assignCode;
        this.isRecursive = false;
        this.readMode = true;
    }

    /**
     * Default ctor that leaves blank (not null) members
     * @param initCode the init script
     * @param assignCode the access for the inited code
     * @param isRecursive could this variable be recursive?
     */
    public OutboundVariable(String initCode, String assignCode, boolean isRecursive)
    {
        this.initCode = initCode;
        this.assignCode = assignCode;
        this.isRecursive = isRecursive;
        this.readMode = true;
    }

    /**
     * @param initCode The initCode to set.
     */
    public void setInitCode(String initCode)
    {
        if (readMode)
        {
            log.warn("Warning: write in read mode");
        }

        this.initCode = initCode;
    }

    /**
     * @param assignCode The assignCode to set.
     */
    public void setAssignCode(String assignCode)
    {
        if (readMode)
        {
            log.warn("Warning: write in read mode");
        }

        this.assignCode = assignCode;
    }

    /**
     * @param isRecursive the isRecursive to set
     */
    public void setRecursive(boolean isRecursive)
    {
        if (readMode)
        {
            log.warn("Warning: write in read mode");
        }

        this.isRecursive = isRecursive;
    }

    /**
     * @return Returns the initCode.
     */
    public String getInitCode()
    {
        readMode = true;
        return initCode;
    }

    /**
     * @return Returns the assignCode.
     */
    public String getAssignCode()
    {
        readMode = true;
        return assignCode;
    }

    /**
     * @return the isRecursive
     */
    public boolean isRecursive()
    {
        readMode = true;
        return isRecursive;
    }

    /**
     * Is this variable potentially recursive? In other words do we need to
     * break out of JSON syntax?
     */
    private boolean isRecursive = true;

    /**
     * The code to be executed to initialize any variables
     */
    private String initCode = "";

    /**
     * The code to be executed to get the value of the initialized data
     */
    private String assignCode = "";

    /**
     * If we change recursivity then people should treat us differently so we
     * would like to be immutable, however we can't do that because we don't
     * know all settings at create time. So we implement a write/read toggle and
     * deny writes after any read.
     */
    private boolean readMode = false;

    /**
     * The log stream
     */
    private static final Logger log = Logger.getLogger(OutboundVariable.class);
}
