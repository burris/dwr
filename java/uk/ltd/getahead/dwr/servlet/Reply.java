package uk.ltd.getahead.dwr.servlet;

/**
 * @author
 */
public class Reply
{
    /**
     * @return Returns the body.
     */
    public String getBody()
    {
        return body;
    }

    /**
     * @param body The body to set.
     */
    public void setBody(String body)
    {
        this.body = body;
    }

    /**
     * @return Returns the mimeType.
     */
    public String getMimeType()
    {
        return mimeType;
    }

    /**
     * @param mimeType The mimeType to set.
     */
    public void setMimeType(String mimeType)
    {
        this.mimeType = mimeType;
    }

    private String mimeType;

    private String body;
}
