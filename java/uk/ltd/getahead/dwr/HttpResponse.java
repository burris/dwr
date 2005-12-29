package uk.ltd.getahead.dwr;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class HttpResponse
{
    /**
     * @return the body
     */
    public byte[] getBody()
    {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(byte[] body)
    {
        this.body = body;
    }

    /**
     * @param replyString
     */
    public void setBody(String replyString)
    {
        // TODO: Think about encoding. The servlet spec says it uses a default
        // value of "ISO-8859-1".
        this.body = replyString.getBytes();
    }

    /**
     * @return the mimeType
     */
    public String getMimeType()
    {
        return mimeType;
    }

    /**
     * @param mimeType the mimeType to set
     */
    public void setMimeType(String mimeType)
    {
        this.mimeType = mimeType;
    }

    private byte[] body;
    private String mimeType;
}
