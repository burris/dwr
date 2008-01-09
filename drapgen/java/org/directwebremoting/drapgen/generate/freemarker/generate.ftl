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
package ${type.packageName};

import java.lang.reflect.Constructor;
import java.util.Date;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.extend.CallbackHelper;
import org.directwebremoting.proxy.Callback;
import org.directwebremoting.proxy.ScriptProxy;
import org.directwebremoting.proxy.io.Context;

/**
 * ${type.documentation!"(No documentation)"}
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class ${type.name} <#if type.superClass??>extends ${type.superClass.fullName}</#if>
{
    /**
     * All reverse ajax proxies need context to work from
     * @param scriptProxy The place we are writing scripts to
     * @param context The script that got us to where we are now
     */
    public ${type.name}(Context context, String extension, ScriptProxy scriptProxy)
    {
        super(context, extension, scriptProxy);
    }

<#--    <#list type.constructors as constructor>
    <@createProxyConstructor constructor=constructor/>
    </#list>
-->
    <#list type.constants as constant>
    /**
     * ${constant.documentation!"(No documentation)"}
     */
    public static final ${constant.type} ${constant.name} = ${constant.value};
    </#list>

    <#list type.methods as method>
    <@createMethod method=method/>
    </#list>
}

<#macro subroutineDoc subroutine>
    /**
     * ${subroutine.documentation!"(No documentation)"}
     <#list subroutine.parameters as parameter>
     * @param ${parameter.name} ${parameter.documentation!"(No documentation)"}
     </#list>
     */
</#macro>

<#macro createProxyConstructor constructor>
    <@subroutineDoc subroutine=constructor/>
    public ${type.name}(<#list constructor.parameters as parameter>${parameter.type} ${parameter.name}<#if parameter_has_next>, </#if></#list>)
    {
        super((Context) null, (String) null, (ScriptProxy) null);
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("new ${type.name}"<#list constructor.parameters as parameter>, ${parameter.name}</#list>);
        setInitScript(script);
    }

</#macro>

<#macro createMethod method>
  <#if method.type == 'void'>
    <@createMethodNoReturn method=method/>
  <#else>
    // Can't create proxy for ${method.name}

  </#if>
</#macro>

<#macro createMethodNoReturn method>
    <@subroutineDoc subroutine=method/>
    public void ${method.name}(<#list method.parameters as parameter>${parameter.type} ${parameter.name}<#if parameter_has_next>, </#if></#list>)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("${method.name}"<#list method.parameters as parameter>, ${parameter.name}</#list>);
        getScriptProxy().addScript(script);
    }

</#macro>
