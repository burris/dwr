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
package org.getahead.dwrdemo.ticketcenter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletContext;

import jsx3.GI;
import jsx3.app.Server;
import jsx3.gui.Form;
import jsx3.gui.LayoutGrid;
import jsx3.gui.Matrix;
import jsx3.gui.TextBox;
import jsx3.xml.CdfDocument;
import jsx3.xml.Record;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ServerContext;
import org.directwebremoting.ServerContextFactory;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.proxy.browser.Window;
import org.getahead.dwrdemo.util.RandomData;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class CallCenter implements Runnable
{
    /**
     * Create a new publish thread and start it
     */
    public CallCenter()
    {
        WebContext webContext = WebContextFactory.get();
        ServletContext servletContext = webContext.getServletContext();

        serverContext = ServerContextFactory.get(servletContext);

        // A bit nasty: the call to serverContext.getScriptSessionsByPage()
        // below could fail because the system might need to read web.xml which
        // means it needs a ServletContext, which is only available using
        // WebContext, which in turn requires a DWR thread. We can cache the
        // results simply by calling this in a DWR thread, as we are now.
        webContext.getScriptSessionsByPage("");

        synchronized (CallCenter.class)
        {
            if (worker == null)
            {
                worker = new Thread(this, "CallCenter");
                worker.start();
            }
        }

        // Start with some calls waiting
        addRandomKnownCall();
        addRandomUnknownCall();
        addRandomUnknownCall();
        addRandomUnknownCall();
    }

    /**
     * 
     */
    public void alertSupervisor(Call call)
    {
        ScriptSession session = WebContextFactory.get().getScriptSession();
        Window window = new Window(session);
        int handlingId = getHandlingId(session);

        if (handlingId != -1)
        {
            window.alert("No call found");
            return;
        }

        synchronized (calls)
        {
            Call old = findCaller(handlingId);
            if (old == null)
            {
                window.alert("That caller hung up, please select another");
                return;
            }

            old.setName(call.getName());
            old.setAddress(call.getAddress());
            old.setNotes(call.getNotes());
            old.setHandled(false);
            old.setSupervisorAlert(true);
            update();
        }
    }

    /**
     * 
     */
    public void completeHandling(Call call)
    {
        ScriptSession session = WebContextFactory.get().getScriptSession();
        Window window = new Window(session);
        int handlingId = getHandlingId(session);

        if (handlingId != -1)
        {
            window.alert("No call found");
            return;
        }

        synchronized (calls)
        {
            Call old = findCaller(handlingId);
            if (old == null)
            {
                window.alert("That caller hung up, please select another");
                return;
            }

            log.debug("Call completed: " + call);
            calls.remove(call);
            update();
        }
    }

    /**
     * 
     */
    public void beginHandling(int id)
    {
        ScriptSession session = WebContextFactory.get().getScriptSession();
        Window window = new Window(session);
        int handlingId = getHandlingId(session);

        if (handlingId != -1)
        {
            window.alert("Please finish handling the current call before selecting another");
            return;
        }

        synchronized (calls)
        {
            Call call = findCaller(id);
            if (call == null)
            {
                log.debug("Caller not found: " + id);
                window.alert("That caller hung up, please select another");
            }
            else
            {
                if (call.isHandled())
                {
                    window.alert("That call is being handled, please select another");
                    return;
                }

                session.setAttribute("handlingId", handlingId);

                call.setHandled(true);
                Server ticketcenter = GI.getServer(session, "ticketcenter");
                ticketcenter.getJSXByName("textPhone", TextBox.class).setValue(call.getPhoneNumber());
                ticketcenter.getJSXByName("textName", TextBox.class).setValue(call.getName());
                ticketcenter.getJSXByName("textNotes", TextBox.class).setValue(call.getNotes());
                setFormEnabled(true);
                ticketcenter.getJSXByName("layoutForm", TextBox.class).setBackgroundColor("#000", true);

                update();
            }
        }
    }

    /**
     * 
     */
    public void cancelHandling()
    {
        ScriptSession session = WebContextFactory.get().getScriptSession();
        Window window = new Window(session);
        int handlingId = getHandlingId(session);
        if (handlingId == -1)
        {
            window.alert("That caller hung up, please select another");
            return;
        }

        synchronized (calls)
        {
            Call call = findCaller(handlingId);
            call.setHandled(false);
            update();
        }

        deselect();
    }

    /**
     * 
     */
    private Call findCaller(int id)
    {
        Call reply = null;
        // We could optimize this, but since there are less than 20 people
        // in the queue ...
        for (Call call : calls)
        {
            if (call.getId() == id)
            {
                reply = call;
            }
        }
        return reply;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    public void run()
    {
        try
        {
            log.info("Starting Publisher thread");

            while (!Thread.currentThread().isInterrupted())
            {
                String contextPath = serverContext.getContextPath();
                if (contextPath != null)
                {
                    synchronized (calls)
                    {
                        switch (random.nextInt(5))
                        {
                        case 0:
                        case 1:
                            addRandomUnknownCall();
                            break;

                        case 2:
                            addRandomKnownCall();
                            break;

                        case 3:
                            removeRandomCall();
                            break;

                        default:
                            break;
                        }

                        update();
                    }
                }

                int timeToSleep = random.nextInt(10000);
                Thread.sleep(timeToSleep);
            }
        }
        catch (InterruptedException ex)
        {
            // Ignore, we expect this
        }
        finally
        {
            log.info("Stopping Publisher thread");
        }
    }

    /**
     * 
     */
    private void removeRandomCall()
    {
        if (calls.size() > 0)
        {
            int toDelete = random.nextInt(calls.size());
            Call removed = calls.remove(toDelete);

            log.info("Random Event: Caller hangs up: " + removed.getPhoneNumber());
        }
    }

    /**
     * 
     */
    private void addRandomKnownCall()
    {
        if (calls.size() < 10)
        {
            Call call = getRandomCall();
            call.setId(getNextId());
            calls.add(call);

            log.info("Random Event: New caller: " + call.getName());
        }
    }

    /**
     * 
     */
    private void addRandomUnknownCall()
    {
        if (calls.size() < 10)
        {
            String phoneNumber = RandomData.getPhoneNumber(random.nextInt(3) != 0);
            Call call = new Call();
            call.setPhoneNumber(phoneNumber);
            call.setId(getNextId());
            calls.add(call);

            log.info("Random Event: New caller: " + call.getPhoneNumber());
        }
    }

    /**
     *
     */
    private void update()
    {
        String contextPath = serverContext.getContextPath();
        Collection<ScriptSession> sessions = serverContext.getScriptSessionsByPage(contextPath + "/gi/ticketcenter.html");
        Collection<ScriptSession> sessions2 = serverContext.getScriptSessionsByPage(contextPath + "/gi/ticketcenter2.html");
        sessions.addAll(sessions2);

        Server ticketcenter = GI.getServer(sessions, "ticketcenter");

        // Some tweaks so GI redraws everything without needing further explanation
        // We copy the id to jsxid, and ensure that the fields for the check-boxes are
        // 0 or 1 rather than true or false. We also check that any handled caller
        // is still around and has not hung up
        CdfDocument cdfdoc = new CdfDocument("jsxroot");
        Date now = new Date();
        for (Call call : calls)
        {
            Record record = new Record("" + call.getId());

            record.setAttribute("phoneNumber", call.getPhoneNumber());

            String name = call.getName();
            if (name == null || name.equals(""))
            {
                name = "?";
            }
            record.setAttribute("name", name);

            long timePlain = now.getTime() - call.getCallStarted().getTime();
            int time = 10000 * Math.round(timePlain / 10000);
            record.setAttribute("time", "" + time);

            String handled = call.isHandled() ? "JSXAPPS/ticketcenter/images/configure.png" : "";
            record.setAttribute("handled", handled);

            String supervisorAlert = call.isSupervisorAlert() ? "JSXAPPS/ticketcenter/images/irkickflash.png" : "";
            record.setAttribute("supervisorAlert", supervisorAlert);

            for (ScriptSession session : sessions)
            {
                int handlingId = getHandlingId(session);
                if (handlingId == call.getId())
                {
                    session.setAttribute("handlingIdFound", Boolean.TRUE);
                }
            }
            cdfdoc.appendRecord(record);
        }

        // Convert the data into a CDF document and post to GI
        ticketcenter.getCache().setDocument("callers", cdfdoc);
        ticketcenter.getJSXByName("listCallers", Matrix.class).repaint(null);

        // Work out what to do if the caller we're working on has hung up
        for (ScriptSession session : sessions)
        {
            if (session.getAttribute("handlingIdFound") != null)
            {
                Window window = new Window(session);
                window.alert("It appears that this caller has hung up. Please select another.");
                deselect();
            }
        }
    }

    /**
     * Create a random person
     * @return a random person
     */
    private static Call getRandomCall()
    {
        Call call = new Call();
        call.setId(getNextId());
        call.setName(RandomData.getFullName());
        String[] addressAndNumber = RandomData.getAddressAndNumber();
        call.setAddress(addressAndNumber[0]);
        call.setPhoneNumber(addressAndNumber[1]);
        return call;
    }

    /**
     * Disable all the elements in the form
     * @param enabled True to enable the elements/false ...
     */
    private void setFormEnabled(boolean enabled)
    {
        int state = enabled ? Form.STATEENABLED : Form.STATEDISABLED;

        for (String element : elements)
        {
            ScriptSession session = WebContextFactory.get().getScriptSession();
            TextBox form = GI.getServer(session, "ticketcenter").getJSX(element, TextBox.class);
            form.setEnabled(state, true);
        }
    }

    private void deselect()
    {
        ScriptSession session = WebContextFactory.get().getScriptSession();

        Server ticketcenter = GI.getServer(session, "ticketcenter");
        session.removeAttribute("handlingId");
        for (String field : fields)
        {
            TextBox form = ticketcenter.getJSX(field, TextBox.class);
            form.setValue("");
        }

        setFormEnabled(false);
        ticketcenter.getJSX("layoutForm", LayoutGrid.class).setBackgroundColor("#EEE", true);
    }

    private int getHandlingId(ScriptSession session)
    {
        Object attribute = session.getAttribute("handlingId");
        if (attribute == null)
        {
            return -1;
        }

        try
        {
            return Integer.parseInt(attribute.toString());
        }
        catch (NumberFormatException ex)
        {
            log.warn("Illegal number format: " + attribute.toString(), ex);
            return -1;
        }
    }

    private String[] fields = new String[] { "textPhone", "textName", "textAddress", "textNotes" };
    private String[] elements = new String[] { "textPhone", "textName", "textAddress", "textPayment", "textNotes", "selectEvent", "selectPaymentType", "buttonBook", "buttonSupervisor", "buttonCancel" };

    /**
     * Get the next unique ID in a thread safe way
     * @return a unique id
     */
    public static synchronized int getNextId()
    {
        return nextId++;
    }

    /**
     * The next ID, to get around serialization issues
     */
    private static int nextId = 1;

    /**
     * The thread that does the work
     */
    protected static Thread worker;

    /**
     * The set of people in our database
     */
    private List<Call> calls = Collections.synchronizedList(new ArrayList<Call>());

    /**
     * We use DWRs ServerContext to find users of a given page
     */
    private ServerContext serverContext;

    /**
     * Used to generate random data
     */
    private Random random = new Random();

    /**
     * The log stream
     */
    private static final Log log = LogFactory.getLog(CallCenter.class);
}
