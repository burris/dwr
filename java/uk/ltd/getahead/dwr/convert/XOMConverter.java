package uk.ltd.getahead.dwr.convert;

import java.io.StringReader;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Node;
import uk.ltd.getahead.dwr.ConversionException;
import uk.ltd.getahead.dwr.Converter;
import uk.ltd.getahead.dwr.InboundContext;
import uk.ltd.getahead.dwr.InboundVariable;
import uk.ltd.getahead.dwr.Messages;
import uk.ltd.getahead.dwr.OutboundContext;
import uk.ltd.getahead.dwr.OutboundVariable;
import uk.ltd.getahead.dwr.compat.BaseV20Converter;
import uk.ltd.getahead.dwr.util.JavascriptUtil;
import uk.ltd.getahead.dwr.util.LocalUtil;

/**
 * An implementation of Converter for DOM objects.
 * @author Joe Walker [joe at eireneh dot com]
 * @version $Id: StringConverter.java,v 1.2 2004/11/04 15:54:07 joe_walker Exp $
 */
public class XOMConverter extends BaseV20Converter implements Converter
{
    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Converter#convertInbound(java.lang.Class, java.util.List, uk.ltd.getahead.dwr.InboundVariable, uk.ltd.getahead.dwr.InboundContext)
     */
    public Object convertInbound(Class paramType, InboundVariable iv, InboundContext inctx) throws ConversionException
    {
        String value = LocalUtil.decode(iv.getValue());

        try
        {
            Builder builder = new Builder();
            Document doc = builder.build(new StringReader(value));

            if (paramType == Document.class)
            {
                return doc;
            }
            else if (paramType == Element.class)
            {
                return doc.getRootElement();
            }

            throw new ConversionException(Messages.getString("DOMConverter.UnusableClass", paramType.getName())); //$NON-NLS-1$
        }
        catch (ConversionException ex)
        {
            throw ex;
        }
        catch (Exception ex)
        {
            throw new ConversionException(ex);
        }
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Converter#convertOutbound(java.lang.Object, uk.ltd.getahead.dwr.OutboundContext)
     */
    public OutboundVariable convertOutbound(Object data, OutboundContext outctx) throws ConversionException
    {
        OutboundVariable ov = outctx.createOutboundVariable(data);
        String varname = ov.getAssignCode();

        try
        {
            // Using XSLT to convert to a stream. Setup the source
            if (!(data instanceof Node))
            {
                throw new ConversionException("Data is not a DOM Node"); //$NON-NLS-1$
            }

            Node node = (Node) data;
            String output = node.toXML();

            StringBuffer buffer = new StringBuffer();
            buffer.append("var "); //$NON-NLS-1$
            buffer.append(varname);
            buffer.append("=DWREngine._unserializeDocument(\""); //$NON-NLS-1$
            buffer.append(jsutil.escapeJavaScript(output));
            buffer.append("\");"); //$NON-NLS-1$

            ov.setInitCode(buffer.toString());
            return ov;
        }
        catch (ConversionException ex)
        {
            throw ex;
        }
        catch (Exception ex)
        {
            throw new ConversionException(ex);
        }
    }

    /**
     * The means by which we strip comments
     */
    private JavascriptUtil jsutil = new JavascriptUtil();
}
