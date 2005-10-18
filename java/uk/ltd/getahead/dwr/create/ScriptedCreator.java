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
package uk.ltd.getahead.dwr.create;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;

import org.apache.bsf.BSFManager;

import uk.ltd.getahead.dwr.Creator;
import uk.ltd.getahead.dwr.ExecutionContext;
import uk.ltd.getahead.dwr.Messages;
import uk.ltd.getahead.dwr.util.Logger;

/**
 * A creator that simply uses the default constructor each time it is called.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class ScriptedCreator extends AbstractCreator implements Creator
{
    /**
     * @return Returns the language.
     */
    public String getLanguage()
    {
        return language;
    }

    /**
     * Are we caching the script (default: false)
     * @return Returns the cacheScript variable
     */
    public String getCacheScript()
    {
        return String.valueOf(cacheScript);
    }

    /**
     * @param cacheScript Whether or not to cache the script.  
     * The default is <b>true</b>. This parameter is only
     * used if scriptPath is used instead of script.
     */
    public void setCacheScript(String cacheScript)
    {
        this.cacheScript = Boolean.valueOf(cacheScript).booleanValue();
    }

    /**
     * @return Returns the path of the script.
     */
    public String getScriptPath()
    {
        return scriptPath;
    }

    /**
     *  @param scriptPath Context reletive path to script.
     **/
    public void setScriptPath(String scriptPath)
    {
        if (scriptSrc != null)
        {
            throw new IllegalArgumentException(Messages.getString("ScriptCreator.MultipleScript")); //$NON-NLS-1$
        }

        this.scriptPath = scriptPath;
    }

    /**
     * @param language The language to set.
     */
    public void setLanguage(String language)
    {
        // if (BSFManager.isLanguageRegistered(language))
        // {
        //     throw new IllegalArgumentException(Messages.getString("ScriptedCreator.IllegalLanguage", language)); //$NON-NLS-1$
        // }
        this.language = language;
    }

    /**
     * @return Returns the script.
     * @throws InstantiationException 
     */
    public String getScript() throws InstantiationException
    {
        if (scriptSrc != null)
        {
            return scriptSrc;
        }

        if (scriptPath == null)
        {
            throw new InstantiationException(Messages.getString("ScriptedCreator.MissingScript")); //$NON-NLS-1$
        }

        // now load the script from the path        
        log.debug("Loading Script from Path: " + scriptPath); //$NON-NLS-1$
        InputStream in = null;
        try
        {
            ExecutionContext ec = ExecutionContext.get();
            ServletContext sc = ec.getServletContext();
            in = sc.getResourceAsStream(scriptPath);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line = null;
            StringBuffer sb = new StringBuffer();

            while ((line = br.readLine()) != null)
            {
                sb.append(line);
            }

            in.close();
            return sb.toString();
        }
        catch (Exception ex)
        {
            log.error(ex.getMessage(), ex);
            throw new InstantiationException(Messages.getString("ScriptCreator.MissingScript")); //$NON-NLS-1$
        }
        finally
        {
            try
            {
                if (null != in)
                {
                    in.close();
                }
            }
            catch (Exception ex)
            {
                log.warn(ex.getMessage(), ex);
            }
        }
    }

    /**
     * @param scriptSrc The script to set.
     */
    public void setScript(String scriptSrc)
    {
        if (scriptPath != null)
        {
            throw new IllegalArgumentException(Messages.getString("ScriptCreator.MultipleScript")); //$NON-NLS-1$
        }

        if (scriptSrc == null || scriptSrc.trim().length() == 0)
        {
            throw new IllegalArgumentException(Messages.getString("ScriptedCreator.MissingScript")); //$NON-NLS-1$
        }

        this.scriptSrc = scriptSrc;
    }

    /**
     * What sort of class do we create?
     * @param classname The name of the class
     */
    public void setClass(String classname)
    {
        try
        {
            this.clazz = Class.forName(classname);
        }
        catch (ClassNotFoundException ex)
        {
            throw new IllegalArgumentException(Messages.getString("Creator.ClassNotFound", classname)); //$NON-NLS-1$
        }
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Creator#getType()
     */
    public Class getType()
    {
        log.debug("Cache Script: " + (scriptPath != null && cacheScript)); //$NON-NLS-1$
        if (clazz == null || (scriptPath != null && !cacheScript))
        {
            try
            {
                clazz = getInstance().getClass();
            }
            catch (InstantiationException ex)
            {
                log.error("Failed to instansiate object to detect type.", ex); //$NON-NLS-1$
                return Object.class;
            }
        }

        return clazz;
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Creator#getInstance()
     */
    public Object getInstance() throws InstantiationException
    {
        try
        {
            log.debug("Loaded Script Source: " + getScript()); //$NON-NLS-1$

            return bsfman.eval(language, (null == scriptPath ? "dwr.xml" : scriptPath), 0, 0, getScript()); //$NON-NLS-1$
        }
        catch (Exception ex)
        {
            log.error("Error executing script", ex); //$NON-NLS-1$
            throw new InstantiationException(Messages.getString("Creator.IllegalAccess")); //$NON-NLS-1$
        }
    }

    /**
     * The log stream
     */
    private static final Logger log = Logger.getLogger(ScriptedCreator.class);

    /**
     * Our script evaluation environment
     */
    private BSFManager bsfman = new BSFManager();

    /**
     * The cached type of object that we are creating.
     */
    private Class clazz = null;

    /**
     * The language that we are scripting in. Passed to BSF.
     */
    private String language = null;

    /**
     * The script that we are asking BSF to execute in order to get an object.
     */
    private String scriptSrc = null;
    
    /**
     * The path of the script we are asking BSF to execute.
     **/
    private String scriptPath = null;
    
    /**
     *  Whether or not to cache the script.  Only used if srciptPath is used.
     *  ie: An inline script is not reloadable
     **/
    private boolean cacheScript=true;
}
