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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ServerContext;
import org.directwebremoting.ServerContextFactory;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.proxy.ScriptProxy;
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
    public String alertSupervisor(int id, Call call)
    {
        synchronized (calls)
        {
            Call old = findCaller(id);
            if (call == null)
            {
                return "That caller hung up, please select another";
            }
            else
            {
                old.setName(call.getName());
                old.setAddress(call.getAddress());
                old.setNotes(call.getNotes());
                old.setHandled(false);
                old.setSupervisorAlert(true);
                update();
                return "";
            }
        }
    }

    /**
     * 
     */
    public String beginHandling(int id)
    {
        synchronized (calls)
        {
            Call call = findCaller(id);
            if (call == null)
            {
                log.debug("Caller not found: " + id);
                return "That caller hung up, please select another";
            }
            else
            {
                if (call.isHandled())
                {
                    return "That call is being handled, please select another";
                }
                else
                {
                    call.setHandled(true);
                    update();
                    return "";
                }
            }
        }
    }

    /**
     * 
     */
    public String cancelHandling(int id)
    {
        synchronized (calls)
        {
            Call call = findCaller(id);
            if (call == null)
            {
                log.debug("Caller not found: " + id);
                return "That caller hung up, please select another";
            }
            else
            {
                call.setHandled(false);
                update();
                return "";
            }
        }
    }

    /**
     * 
     */
    public String completeHandling(int id, Call newCall)
    {
        synchronized (calls)
        {
            Call call = findCaller(id);
            if (call == null)
            {
                log.debug("Caller not found: " + id);
                return "That caller hung up, please select another";
            }
            else
            {
                calls.remove(call);
                update();
                return "";
            }
        }
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
            calls.remove(toDelete);
        }
    }

    /**
     * 
     */
    private void addRandomKnownCall()
    {
        if (calls.size() < 20)
        {
            Call call = getRandomCall();
            call.setId(getNextId());
            calls.add(call);
        }
    }

    /**
     * 
     */
    private void addRandomUnknownCall()
    {
        if (calls.size() < 20)
        {
            String phoneNumber = RandomData.getPhoneNumber(random.nextInt(3) != 0);
            Call call = new Call();
            call.setPhoneNumber(phoneNumber);
            call.setId(getNextId());
            calls.add(call);
        }
    }

    /**
     *
     */
    private void update()
    {
        String contextPath = serverContext.getContextPath();
        Collection<ScriptSession> sessions = serverContext.getScriptSessionsByPage(contextPath + "/gi/ticketcenter.html");
        ScriptProxy proxy = new ScriptProxy(sessions);
        proxy.addFunctionCall("updateCallers", calls, new Date());
    }

    /**
     * Create a random person
     * @return a random person
     */
    public static Call getRandomCall()
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
