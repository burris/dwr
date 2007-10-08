<?xml version="1.0" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:output method="text"/>

<xsl:template match="/">
<xsl:text>/*
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
package org.directwebremoting.proxy.jsx3.lang;

import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class Object
{
    /**
     * Most Reverse Ajax proxies will have a ProxyHelper to aid in generating
     * the correct script.
     * @param helper The new ProxyHelper
     */
    public Object(ProxyHelper helper)
    {
        this.helper = helper;
    }

    /**
     * Return the helper class that lets us know our context in Javascript
     * @return Our ProxyHelper
     */
    protected ProxyHelper getProxyHelper()
    {
        return helper;
    }

    private ProxyHelper helper;
}
</xsl:text>
</xsl:template>

</xsl:stylesheet>
