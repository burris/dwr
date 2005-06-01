package uk.ltd.getahead.testdwr;

public class Message
{
    public Message(String newtext)
    {
        text = newtext;
        if (text.length() > 256)
        {
            text = text.substring(0, 256);
        }
        text = text.replace('<', '[').replace('&', '_');
    }

    public long getId()
    {
        return id;
    }

    public String getText()
    {
        return text;
    }

    long id = System.currentTimeMillis();
    String text;
}
