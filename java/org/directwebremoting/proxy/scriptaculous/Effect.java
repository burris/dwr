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
package org.directwebremoting.proxy.scriptaculous;

import java.util.Collection;

import javax.servlet.ServletContext;

import org.directwebremoting.MarshallException;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.proxy.ScriptProxy;
import org.directwebremoting.proxy.dwrutil.DwrUtil;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 * @
 */
public class Effect extends ScriptProxy
{
    /**
     * Http thread constructor, that affects no browsers.
     * Calls to {@link DwrUtil#addScriptSession(ScriptSession)} or to
     * {@link DwrUtil#addScriptSessions(Collection)} will be needed  
     */
    public Effect()
    {
        super();
    }

    /**
     * Non-http thread constructor, that affects no browsers.
     * Calls to {@link Effect#addScriptSession(ScriptSession)} or to
     * {@link Effect#addScriptSessions(Collection)} will be needed
     * @param sctx The servlet context to allow us to locate a webapp
     */
    public Effect(ServletContext sctx)
    {
        super(sctx);
    }

    /**
     * Http thread constructor that alters a single browser
     * @param scriptSession The browser to alter
     */
    public Effect(ScriptSession scriptSession)
    {
        super(scriptSession);
    }

    /**
     * Non-http thread constructor that alters a single browser
     * @param scriptSession The browser to alter
     * @param sctx The servlet context to allow us to locate a webapp
     */
    public Effect(ScriptSession scriptSession, ServletContext sctx)
    {
        super(scriptSession, sctx);
    }

    /**
     * Http thread constructor that alters a number of browsers
     * @param scriptSessions A collection of ScriptSessions that we should act on.
     */
    public Effect(Collection scriptSessions)
    {
        super(scriptSessions);
    }

    /**
     * Non-http thread constructor that alters a number of browsers
     * @param scriptSessions The browsers to alter
     * @param sctx The servlet context to allow us to locate a webapp
     */
    public Effect(Collection scriptSessions, ServletContext sctx)
    {
        super(scriptSessions, sctx);
    }

    /**
     * Call the script.aculo.us <code>Effect.fade()</code> function.
     * @param elementId The element to effect
     * @throws MarshallException
     */
    public void fade(String elementId) throws MarshallException
    {
        callEffect(elementId, "Fade");
    }

    /**
     * Call the script.aculo.us <code>Effect.appear()</code> function.
     * @param elementId The element to effect
     * @throws MarshallException
     */
    public void appear(String elementId) throws MarshallException
    {
        callEffect(elementId, "Appear");
    }

    /**
     * Call the script.aculo.us <code>Effect.puff()</code> function.
     * @param elementId The element to effect
     * @throws MarshallException
     */
    public void puff(String elementId) throws MarshallException
    {
        callEffect(elementId, "Puff");
    }

    /**
     * Call the script.aculo.us <code>Effect.blindUp()</code> function.
     * @param elementId The element to effect
     * @throws MarshallException
     */
    public void blindUp(String elementId) throws MarshallException
    {
        callEffect(elementId, "BlindUp");
    }

    /**
     * Call the script.aculo.us <code>Effect.blindDown()</code> function.
     * @param elementId The element to effect
     * @throws MarshallException
     */
    public void blindDown(String elementId) throws MarshallException
    {
        callEffect(elementId, "BlindDown");
    }

    /**
     * Call the script.aculo.us <code>Effect.switchOff()</code> function.
     * @param elementId The element to effect
     * @throws MarshallException
     */
    public void switchOff(String elementId) throws MarshallException
    {
        callEffect(elementId, "SwitchOff");
    }

    /**
     * Call the script.aculo.us <code>Effect.dropOut()</code> function.
     * @param elementId The element to effect
     * @throws MarshallException
     */
    public void dropOut(String elementId) throws MarshallException
    {
        callEffect(elementId, "DropOut");
    }

    /**
     * Call the script.aculo.us <code>Effect.shake()</code> function.
     * @param elementId The element to effect
     * @throws MarshallException
     */
    public void shake(String elementId) throws MarshallException
    {
        callEffect(elementId, "Shake");
    }

    /**
     * Call the script.aculo.us <code>Effect.slideDown()</code> function.
     * @param elementId The element to effect
     * @throws MarshallException
     */
    public void slideDown(String elementId) throws MarshallException
    {
        callEffect(elementId, "SlideDown");
    }

    /**
     * Call the script.aculo.us <code>Effect.slideUp()</code> function.
     * @param elementId The element to effect
     * @throws MarshallException
     */
    public void slideUp(String elementId) throws MarshallException
    {
        callEffect(elementId, "SlideUp");
    }

    /**
     * Call the script.aculo.us <code>Effect.squish()</code> function.
     * @param elementId The element to effect
     * @throws MarshallException
     */
    public void squish(String elementId) throws MarshallException
    {
        callEffect(elementId, "Squish");
    }

    /**
     * Call the script.aculo.us <code>Effect.grow()</code> function.
     * @param elementId The element to effect
     * @throws MarshallException
     */
    public void grow(String elementId) throws MarshallException
    {
        callEffect(elementId, "Grow");
    }

    /**
     * Call the script.aculo.us <code>Effect.shrink()</code> function.
     * @param elementId The element to effect
     * @throws MarshallException
     */
    public void shrink(String elementId) throws MarshallException
    {
        callEffect(elementId, "Shrink");
    }

    /**
     * Call the script.aculo.us <code>Effect.pulsate()</code> function.
     * @param elementId The element to effect
     * @throws MarshallException
     */
    public void pulsate(String elementId) throws MarshallException
    {
        callEffect(elementId, "Pulsate");
    }

    /**
     * Call the script.aculo.us <code>Effect.fold()</code> function.
     * @param elementId The element to effect
     * @throws MarshallException
     */
    public void fold(String elementId) throws MarshallException
    {
        callEffect(elementId, "Fold");
    }

    /**
     * Call the script.aculo.us <code>Effect.Fade()</code> function.
     * @param elementId The element to affect
	 * @param options A string containing options to pass to the fade effect, as specified at http://script.aculo.us/
     * @throws MarshallException
     */
    public void fade(String elementId, String options) throws MarshallException
    {
        callEffect(elementId, "Fade", options);
    }

    /**
     * Call the script.aculo.us <code>Effect.Appear()</code> function.
     * @param elementId The element to affect
	 * @param options A string containing options to pass to the appear effect, as specified at http://script.aculo.us/
     * @throws MarshallException
     */
    public void appear(String elementId, String options) throws MarshallException
    {
        callEffect(elementId, "Appear", options);
    }

    /**
     * Call the script.aculo.us <code>Effect.Puff()</code> function.
     * @param elementId The element to affect
	 * @param options A string containing options to pass to the puff effect, as specified at http://script.aculo.us/
     * @throws MarshallException
     */
    public void puff(String elementId, String options) throws MarshallException
    {
        callEffect(elementId, "Puff", options);
    }

    /**
     * Call the script.aculo.us <code>Effect.BlindUp()</code> function.
     * @param elementId The element to affect
	 * @param options A string containing options to pass to the blindup effect, as specified at http://script.aculo.us/
     * @throws MarshallException
     */
    public void blindUp(String elementId, String options) throws MarshallException
    {
        callEffect(elementId, "BlindUp", options);
    }

    /**
     * Call the script.aculo.us <code>Effect.BlindDown()</code> function.
     * @param elementId The element to affect
	 * @param options A string containing options to pass to the blinddown effect, as specified at http://script.aculo.us/
     * @throws MarshallException
     */
    public void blindDown(String elementId, String options) throws MarshallException
    {
        callEffect(elementId, "BlindDown", options);
    }

    /**
     * Call the script.aculo.us <code>Effect.SwitchOff()</code> function.
     * @param elementId The element to affect
	 * @param options A string containing options to pass to the switchf effect, as specified at http://script.aculo.us/
     * @throws MarshallException
     */
    public void switchOff(String elementId, String options) throws MarshallException
    {
        callEffect(elementId, "SwitchOff", options);
    }

    /**
     * Call the script.aculo.us <code>Effect.DropOut()</code> function.
     * @param elementId The element to affect
	 * @param options A string containing options to pass to the dropout effect, as specified at http://script.aculo.us/
     * @throws MarshallException
     */
    public void dropOut(String elementId, String options) throws MarshallException
    {
        callEffect(elementId, "DropOut", options);
    }

    /**
     * Call the script.aculo.us <code>Effect.Shake()</code> function.
     * @param elementId The element to affect
	 * @param options A string containing options to pass to the shake effect, as specified at http://script.aculo.us/
     * @throws MarshallException
     */
    public void shake(String elementId, String options) throws MarshallException
    {
        callEffect(elementId, "Shake", options);
    }

    /**
     * Call the script.aculo.us <code>Effect.SlideDown()</code> function.
     * @param elementId The element to affect
	 * @param options A string containing options to pass to the slidedown effect, as specified at http://script.aculo.us/
     * @throws MarshallException
     */
    public void slideDown(String elementId, String options) throws MarshallException
    {
        callEffect(elementId, "SlideDown", options);
    }

    /**
     * Call the script.aculo.us <code>Effect.SlideUp()</code> function.
     * @param elementId The element to affect
	 * @param options A string containing options to pass to the slideup effect, as specified at http://script.aculo.us/
     * @throws MarshallException
     */
    public void slideUp(String elementId, String options) throws MarshallException
    {
        callEffect(elementId, "SlideUp", options);
    }

    /**
     * Call the script.aculo.us <code>Effect.Squish()</code> function.
     * @param elementId The element to affect
	 * @param options A string containing options to pass to the squish effect, as specified at http://script.aculo.us/
     * @throws MarshallException
     */
    public void squish(String elementId, String options) throws MarshallException
    {
        callEffect(elementId, "Squish", options);
    }

    /**
     * Call the script.aculo.us <code>Effect.Grow()</code> function.
     * @param elementId The element to affect
	 * @param options A string containing options to pass to the grow effect, as specified at http://script.aculo.us/
     * @throws MarshallException
     */
    public void grow(String elementId, String options) throws MarshallException
    {
        callEffect(elementId, "Grow", options);
    }

    /**
     * Call the script.aculo.us <code>Effect.Shrink()</code> function.
     * @param elementId The element to affect
	 * @param options A string containing options to pass to the shrink effect, as specified at http://script.aculo.us/
     * @throws MarshallException
     */
    public void shrink(String elementId, String options) throws MarshallException
    {
        callEffect(elementId, "Shrink", options);
    }

    /**
     * Call the script.aculo.us <code>Effect.Pulsate()</code> function.
     * @param elementId The element to affect
	 * @param options A string containing options to pass to the pulsate effect, as specified at http://script.aculo.us/
     * @throws MarshallException
     */
    public void pulsate(String elementId, String options) throws MarshallException
    {
        callEffect(elementId, "Pulsate", options);
    }

    /**
     * Call the script.aculo.us <code>Effect.Fold()</code> function.
     * @param elementId The element to affect
	 * @param options A string containing options to pass to the fold effect, as specified at http://script.aculo.us/
     * @throws MarshallException
     */
    public void fold(String elementId, String options) throws MarshallException
    {
        callEffect(elementId, "Fold", options);
    }

    /**
     * @param elementId The element to affect
     * @param function The script.aculo.us effect to employ
     * @throws MarshallException
     */
    private void callEffect(String elementId, String function) throws MarshallException
    {
        callEffect(elementId, function, null);
    }

	/*    
     * @param elementId The element to affect
     * @param function The script.aculo.us effect to employ
	 * @param options A string containing options to pass to the script.aculo.us effect, as specified at http://script.aculo.us/
     * @throws MarshallException
     */
    private void callEffect(String elementId, String function, String options) throws MarshallException
    {
        ScriptBuffer script = createScriptBuffer();
        script.appendScript("new Effect.")
            .appendScript(function)
            .appendScript("('")
            .appendScript(elementId)
            .appendScript("'");
        if (options != null && options.length() > 0) {
            script.appendScript(", ")
                .appendScript(options);
        }
        script.appendScript(");");
        addScript(script);
    }
}
