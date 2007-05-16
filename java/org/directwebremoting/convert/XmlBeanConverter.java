package org.directwebremoting.convert;

import java.io.StringWriter;

import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.directwebremoting.dwrp.SimpleOutboundVariable;
import org.directwebremoting.extend.Converter;
import org.directwebremoting.extend.EnginePrivate;
import org.directwebremoting.extend.InboundContext;
import org.directwebremoting.extend.InboundVariable;
import org.directwebremoting.extend.MarshallException;
import org.directwebremoting.extend.OutboundContext;
import org.directwebremoting.extend.OutboundVariable;
import org.directwebremoting.util.LocalUtil;

/**
 * A Converter for Apache XMLBeans.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class XmlBeanConverter extends BaseV20Converter implements Converter
{
    /* (non-Javadoc)
     * @see org.directwebremoting.extend.Converter#convertInbound(java.lang.Class, org.directwebremoting.extend.InboundVariable, org.directwebremoting.extend.InboundContext)
     */
    public Object convertInbound(Class<?> paramType, InboundVariable iv, InboundContext inctx) throws MarshallException
    {
        String value = LocalUtil.decode(iv.getValue());

        try
        {
            XmlObject document = XmlObject.Factory.parse(value);
            if (paramType == XmlObject.class)
            {
                return document;
            }

            throw new MarshallException(paramType);
        }
        catch (MarshallException me)
        {
            throw me;
        }
        catch (Exception e)
        {
            throw new MarshallException(paramType, e);
        }
    }

    /* (non-Javadoc)
     * @see org.directwebremoting.extend.Converter#convertOutbound(java.lang.Object, org.directwebremoting.extend.OutboundContext)
     */
    public OutboundVariable convertOutbound(Object data, OutboundContext outctx) throws MarshallException
    {
        try
        {
            if (!(data instanceof XmlObject))
            {
                throw new MarshallException(data.getClass());
            }

            XmlObject document = (XmlObject) data;

            XmlOptions xmlOptions = new XmlOptions();
            // following line may be omitted or made dynamic
            xmlOptions.setCharacterEncoding("ISO-8859-1");
            // unfortunately with XmlOptions there is no way to
            // remove namespaces

            // using writer since encoding header isn't serviced with xmlText
            StringWriter writer = new StringWriter();
            document.save(writer, xmlOptions);

            String script = EnginePrivate.xmlStringToJavascriptDom(writer.toString());
            OutboundVariable ov = new SimpleOutboundVariable(script, outctx, false);

            outctx.put(data, ov);

            return ov;
        }
        catch (Exception ex)
        {
            throw new MarshallException(data.getClass(), ex);
        }
    }
}
