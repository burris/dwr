package org.getahead.dwrdemo.monitor;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.directwebremoting.ScriptSession;
import org.directwebremoting.ServerContext;
import org.directwebremoting.ServerContextFactory;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.impl.DefaultScriptSessionManager;
import org.directwebremoting.proxy.dwr.Util;
import org.directwebremoting.util.Logger;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class Control extends TimerTask
{
    /**
     *
     */
    public Control()
    {
        ServletContext servletContext = WebContextFactory.get().getServletContext();
        sctx = ServerContextFactory.get(servletContext);

        WebContext wctx = WebContextFactory.get();
        contextPath = wctx.getHttpServletRequest().getContextPath();

        Timer timer = new Timer();
        long delay = 10000;
        long period = 10000;
        timer.scheduleAtFixedRate(this, delay, period);
    }

    /**
     * Just allows the browser to let the server know we are here
     */
    public void includeMe()
    {
        log.debug("Included");
    }

    /**
     * 
     */
    public void takeNote()
    {
        log.debug("takeNote");

        synchronized (browsers)
        {
            WebContext webContext = WebContextFactory.get();
            HttpServletRequest request = webContext.getHttpServletRequest();
            String httpSessionId = request.getRequestedSessionId();

            Browser browser = (Browser) browsers.get(httpSessionId);
            if (browser == null)
            {
                browser = new Browser(httpSessionId);
                browsers.put(httpSessionId, browser);
            }

            browser.setUserAgent(request.getHeader("User-Agent"));
            browser.setIpAddress(request.getRemoteAddr());
        }
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    public void run()
    {
        synchronized (browsers)
        {
            ServletContext servletContext = sctx.getServletContext();
            Object published = servletContext.getAttribute(ATTRIBUTE_CONTROL);
            if (published == null)
            {
                servletContext.setAttribute(ATTRIBUTE_CONTROL, this);
            }
    
            // For all the browsers on the current page:
            Collection watchers = sctx.getScriptSessionsByPage(contextPath + "/monitor/");
            if (watchers.size() == 0)
            {
                log.debug("Nothing to monitor");
                return;
            }

            // First we go through the browsers making the ScriptViews unverified
            for (Iterator bit = browsers.values().iterator(); bit.hasNext();)
            {
                Browser browser = (Browser) bit.next();
                Map scriptViews = browser.getScriptViews();
                for (Iterator sit = scriptViews.values().iterator(); sit.hasNext();)
                {
                    ScriptView scriptView = (ScriptView) sit.next();
                    scriptView.setVerified(false);
                }
            }

            // Then we go through the known ScriptSessions verifying
            Collection everyone = sctx.getAllScriptSessions();
            for (Iterator it = everyone.iterator(); it.hasNext();)
            {
                ScriptSession scriptSession = (ScriptSession) it.next();
                String httpSessionId = (String) scriptSession.getAttribute(DefaultScriptSessionManager.ATTRIBUTE_HTTPSESSIONID);
                String page = (String) scriptSession.getAttribute(DefaultScriptSessionManager.ATTRIBUTE_PAGE);

                Browser browser = (Browser) browsers.get(httpSessionId);
                if (browser == null)
                {
                    browser = new Browser(httpSessionId);
                    browsers.put(httpSessionId, browser);
                }

                ScriptView scriptView = (ScriptView) browser.getScriptViews().get(scriptSession.getId());
                if (scriptView == null)
                {
                    scriptView = new ScriptView(page, scriptSession);
                }

                scriptView.setVerified(true);
            }

            // And finally remove all the unverified script sessions
            for (Iterator bit = browsers.values().iterator(); bit.hasNext();)
            {
                Browser browser = (Browser) bit.next();
                Map scriptViews = browser.getScriptViews();
                for (Iterator sit = scriptViews.values().iterator(); sit.hasNext();)
                {
                    ScriptView scriptView = (ScriptView) sit.next();
                    if (!scriptView.isVerified())
                    {
                        sit.remove();
                    }
                }
            }

            // Now paint the UI on all the remote browsers
            Util util = new Util(watchers);
            int index = 0;
            for (Iterator bit = browsers.values().iterator(); bit.hasNext();)
            {
                Browser browser = (Browser) bit.next();

                // Clone the node
                util.removeNode("browserTemplate" + index);
                util.cloneNode("browserTemplate", "", "" + index);
                util.setStyle("browserTemplate" + index, "display", "block");

                // Fill out the basic template information
                util.setValue("ipAddress" + index, browser.getIpAddress());
                util.setValue("userAgent" + index, browser.getUserAgent());

                // Fill out the table
                Map scriptViews = browser.getScriptViews();
                for (Iterator sit = scriptViews.values().iterator(); sit.hasNext();)
                {
                    ScriptView scriptView = (ScriptView) sit.next();
                    String[][] data = new String[][]
                    {
                        {
                            "" + scriptView.getClientId(),
                            scriptView.getPage(),
                            "",
                        }
                    };
                    util.addRows("browserTemplate" + index, data);
                }

                index++;
            }
        }
    }

    /**
     * Out current list of known browsers
     */
    private final Map browsers = new HashMap();

    /**
     * Our key to get hold of ServerContexts
     */
    private final ServerContext sctx;

    /**
     * Where do we sit as a webapp?
     */
    private final String contextPath;

    /**
     * 
     */
    public static final String ATTRIBUTE_CONTROL = "org.getahead.dwrdemo.monitor.Control";

    /**
     * The log stream
     */
    protected static final Logger log = Logger.getLogger(Control.class);
}
