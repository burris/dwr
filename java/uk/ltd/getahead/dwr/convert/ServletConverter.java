package uk.ltd.getahead.dwr.convert;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uk.ltd.getahead.dwr.Converter;
import uk.ltd.getahead.dwr.InboundContext;
import uk.ltd.getahead.dwr.InboundVariable;
import uk.ltd.getahead.dwr.OutboundContext;
import uk.ltd.getahead.dwr.OutboundVariable;
import uk.ltd.getahead.dwr.WebContext;
import uk.ltd.getahead.dwr.WebContextFactory;
import uk.ltd.getahead.dwr.compat.BaseV20Converter;

/**
 * A converter that magics up HTTP objects
 * @author Joe Walker [joe at eireneh dot com]
 * @version $Id: StringConverter.java,v 1.2 2004/11/04 15:54:07 joe_walker Exp $
 */
public class ServletConverter extends BaseV20Converter implements Converter
{
    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Converter#convertInbound(java.lang.Class, java.util.List, uk.ltd.getahead.dwr.InboundVariable, uk.ltd.getahead.dwr.InboundContext)
     */
    public Object convertInbound(Class paramType, InboundVariable iv, InboundContext inctx)
    {
        WebContext webcx = WebContextFactory.get();

        if (HttpServletRequest.class.isAssignableFrom(paramType))
        {
            return webcx.getHttpServletRequest();
        }

        if (HttpServletResponse.class.isAssignableFrom(paramType))
        {
            return webcx.getHttpServletResponse();
        }

        if (ServletConfig.class.isAssignableFrom(paramType))
        {
            return webcx.getServletConfig();
        }

        if (ServletContext.class.isAssignableFrom(paramType))
        {
            return webcx.getServletContext();
        }

        if (HttpSession.class.isAssignableFrom(paramType))
        {
            return webcx.getSession(true);
        }

        return null;
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Converter#convertOutbound(java.lang.Object, uk.ltd.getahead.dwr.OutboundContext)
     */
    public OutboundVariable convertOutbound(Object data, OutboundContext outctx)
    {
        return new OutboundVariable("", "null"); //$NON-NLS-1$ //$NON-NLS-2$
    }
}
