package uk.ltd.getahead.chat;

import java.util.LinkedList;
import java.util.List;

import uk.ltd.getahead.dwr.Browser;
import uk.ltd.getahead.dwr.ClientScript;
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
        if (text != null &&
            text.trim().length() > 0)
        {
            messages.addFirst(new Message(text));
            while (messages.size() > 10)
            {
                messages.removeLast();
            }
        }

        Browser browser = WebContextFactory.get().getBrowser();
        browser.addScript(new ClientScript("alert('hi');")); //$NON-NLS-1$

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
