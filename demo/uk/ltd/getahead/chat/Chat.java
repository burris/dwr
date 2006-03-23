package uk.ltd.getahead.chat;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import uk.ltd.getahead.dwr.MarshallException;
import uk.ltd.getahead.dwr.OutboundVariable;
import uk.ltd.getahead.dwr.ScriptSession;
import uk.ltd.getahead.dwr.WebContext;
import uk.ltd.getahead.dwr.WebContextFactory;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class Chat
{
    /**
     * @param text The new message text to add
     * @return a list of the current messages
     */
    public List addMessage(String text)
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
            String eval = ov.getInitCode() + "receiveMessages(" + ov.getAssignCode() + ")"; //$NON-NLS-1$ //$NON-NLS-2$

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

        return messages;
    }

    /**
     * @return a list of the current messages
     */
    public List getMessages()
    {
        return messages;
    }

    private LinkedList messages = new LinkedList();
}
