package uk.ltd.getahead.testdwr;

import java.util.LinkedList;
import java.util.List;

public class Chat
{
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

        return messages;
    }

    public List getMessages()
    {
        return messages;
    }

    private static LinkedList messages = new LinkedList();
}
