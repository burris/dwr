package uk.ltd.getahead.chat;

import java.util.Iterator;
import java.util.LinkedList;

import org.directwebremoting.MarshallException;
import org.directwebremoting.OutboundVariable;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.util.Logger;


/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class Chat
{
    /**
     * @param text The new message text to add
     */
    public void addMessage(String text)
    {
        if (text != null && text.trim().length() > 0)
        {
            messages.addFirst(new Message(text));
            while (messages.size() > 10)
            {
                messages.removeLast();
            }
        }

        WebContext wctx = WebContextFactory.get();
        String currentPage = wctx.getCurrentPage();

        try
        {
            OutboundVariable ov = wctx.toJavascript(messages);
            String eval = ov.getInitCode() + "receiveMessages(" + ov.getAssignCode() + ");"; //$NON-NLS-1$ //$NON-NLS-2$

            // Loop over all the users on the current page
            for (Iterator it = wctx.getScriptSessionsByPage(currentPage); it.hasNext();)
            {
                ScriptSession otherSession = (ScriptSession) it.next();
                otherSession.addScript(eval);
            }
        }
        catch (MarshallException ex)
        {
            ex.printStackTrace();
        }
    }

    /**
     * The current set of messages
     */
    private LinkedList messages = new LinkedList();

    /**
     * 
     */
    public void pingMe()
    {
        WebContext wctx = WebContextFactory.get();
        final ScriptSession scriptSession = wctx.getScriptSession();
        Thread worker = new Thread(new Runnable()
        {
            public void run()
            {
                int count = 0;
                while (count < 100)
                {
                    count++;
                    try
                    {
                        log.debug("count=" + count); //$NON-NLS-1$
                        scriptSession.addScript("DWRUtil.setValue('ping', 'count=" + count + "');"); //$NON-NLS-1$ //$NON-NLS-2$
                        Thread.sleep(1000);
                    }
                    catch (Exception ex)
                    {
                        log.warn("Waking:", ex); //$NON-NLS-1$
                    }
                }
            }
        });
        worker.start();
    }

    /**
     * The log stream
     */
    protected static final Logger log = Logger.getLogger(Chat.class);
}
