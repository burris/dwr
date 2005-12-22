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
package uk.ltd.getahead.dwr;

import uk.ltd.getahead.dwr.AccessControl;
import uk.ltd.getahead.dwr.AjaxFilterManager;
import uk.ltd.getahead.dwr.ConverterManager;
import uk.ltd.getahead.dwr.CreatorManager;
import uk.ltd.getahead.dwr.WebContextBuilder;
import uk.ltd.getahead.dwr.servlet.Processor;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class StartupState
{
    /**
     * @return Returns the accessControl.
     */
    public AccessControl getAccessControl()
    {
        return accessControl;
    }

    /**
     * @param accessControl The accessControl to set.
     */
    public void setAccessControl(AccessControl accessControl)
    {
        this.accessControl = accessControl;
    }

    /**
     * @return Returns the ajaxFilterManager.
     */
    public AjaxFilterManager getAjaxFilterManager()
    {
        return ajaxFilterManager;
    }

    /**
     * @param ajaxFilterManager The ajaxFilterManager to set.
     */
    public void setAjaxFilterManager(AjaxFilterManager ajaxFilterManager)
    {
        this.ajaxFilterManager = ajaxFilterManager;
    }

    /**
     * @return Returns the converterManager.
     */
    public ConverterManager getConverterManager()
    {
        return converterManager;
    }

    /**
     * @param converterManager The converterManager to set.
     */
    public void setConverterManager(ConverterManager converterManager)
    {
        this.converterManager = converterManager;
    }

    /**
     * @return Returns the creatorManager.
     */
    public CreatorManager getCreatorManager()
    {
        return creatorManager;
    }

    /**
     * @param creatorManager The creatorManager to set.
     */
    public void setCreatorManager(CreatorManager creatorManager)
    {
        this.creatorManager = creatorManager;
    }

    /**
     * @return Returns the processor.
     */
    public Processor getProcessor()
    {
        return processor;
    }

    /**
     * @param processor The processor to set.
     */
    public void setProcessor(Processor processor)
    {
        this.processor = processor;
    }

    /**
     * @return Returns the webContextBuilder.
     */
    public WebContextBuilder getWebContextBuilder()
    {
        return webContextBuilder;
    }

    /**
     * @param webContextBuilder The webContextBuilder to set.
     */
    public void setWebContextBuilder(WebContextBuilder webContextBuilder)
    {
        this.webContextBuilder = webContextBuilder;
    }

    private ConverterManager converterManager;

    private CreatorManager creatorManager;

    private AjaxFilterManager ajaxFilterManager;

    private AccessControl accessControl;

    private WebContextBuilder webContextBuilder;

    private Processor processor;
}
