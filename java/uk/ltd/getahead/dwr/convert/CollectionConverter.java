package uk.ltd.getahead.dwr.convert;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import uk.ltd.getahead.dwr.ConversionConstants;
import uk.ltd.getahead.dwr.ConversionException;
import uk.ltd.getahead.dwr.Converter;
import uk.ltd.getahead.dwr.ConverterManager;
import uk.ltd.getahead.dwr.InboundContext;
import uk.ltd.getahead.dwr.InboundVariable;
import uk.ltd.getahead.dwr.Messages;
import uk.ltd.getahead.dwr.OutboundContext;
import uk.ltd.getahead.dwr.OutboundVariable;
import uk.ltd.getahead.dwr.util.LocalUtil;
import uk.ltd.getahead.dwr.util.Logger;

/**
 * An implementation of Converter for Collections of Strings.
 * @author Joe Walker [joe at eireneh dot com]
 * @version $Id: StringConverter.java,v 1.2 2004/11/04 15:54:07 joe_walker Exp $
 */
public class CollectionConverter extends BaseV20Converter implements Converter
{
    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Converter#init(uk.ltd.getahead.dwr.DefaultConfiguration)
     */
    public void setConverterManager(ConverterManager newConfig)
    {
        this.config = newConfig;
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Converter#convertInbound(java.lang.Class, java.util.List, uk.ltd.getahead.dwr.InboundVariable, uk.ltd.getahead.dwr.InboundContext)
     */
    public Object convertInbound(Class paramType, InboundVariable iv, InboundContext inctx) throws ConversionException
    {
        String value = iv.getValue();

        // If the text is null then the whole bean is null
        if (value.trim().equals(ConversionConstants.INBOUND_NULL))
        {
            return null;
        }

        if (!value.startsWith(ConversionConstants.INBOUND_ARRAY_START))
        {
            throw new IllegalArgumentException(Messages.getString("CollectionConverter.MissingOpener", ConversionConstants.INBOUND_ARRAY_START)); //$NON-NLS-1$
        }

        if (!value.endsWith(ConversionConstants.INBOUND_ARRAY_END))
        {
            throw new IllegalArgumentException(Messages.getString("CollectionConverter.MissingCloser", ConversionConstants.INBOUND_ARRAY_END)); //$NON-NLS-1$
        }

        value = value.substring(1, value.length() - 1);

        try
        {
            Method method = inctx.getCurrentMethod();
            int paramNum = inctx.getCurrentParameterNum();

            Class subtype = config.getExtraTypeInfo(method, paramNum, 0);
            if (subtype == null)
            {
                log.warn("Missing type info for " + method.getName() + "(), param=" + paramNum + ". Assuming this is a collection of Strings. Please add to <signatures> in dwr.xml"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                subtype = String.class;
            }
            else
            {
                log.debug("Using extra type info for " + method.getName() + "(), param=" + paramNum + " of " + subtype); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            }

            Collection col = null;

            // If they want an iterator then just use an array list and fudge
            // at the end.
            if (Iterator.class.isAssignableFrom(paramType))
            {
                col = new ArrayList();
            }
            // If paramType is concrete then just use whatever we've got.
            else if (!paramType.isInterface() && !Modifier.isAbstract(paramType.getModifiers()))
            {
                // If there is a problem creating the type then we have no way
                // of completing this - they asked for a specific type and we
                // can't create that type. I don't know of a way of finding
                // subclasses that might be instaniable so we accept failure.
                col = (Collection) paramType.newInstance();
            }
            // If they want a set then use HashSet
            else if (Set.class.isAssignableFrom(paramType))
            {
                col = new HashSet();
            }
            // If they want a list then use an ArrayList
            else if (List.class.isAssignableFrom(paramType))
            {
                col = new ArrayList();
            }
            // If they just want a collection then just use an ArrayList
            else if (Collection.class.isAssignableFrom(paramType))
            {
                col = new ArrayList();
            }
            else
            {
                throw new ConversionException(Messages.getString("CollectionConverter.ConvertError") + paramType.getName()); //$NON-NLS-1$
            }

            // We should put the new object into the working map in case it
            // is referenced later nested down in the conversion process.
            inctx.addConverted(iv, col);

            StringTokenizer st = new StringTokenizer(value, ConversionConstants.INBOUND_ARRAY_SEPARATOR);
            int size = st.countTokens();
            for (int i = 0; i < size; i++)
            {
                String token = st.nextToken();

                String[] split = LocalUtil.splitInbound(token);
                InboundVariable nested = new InboundVariable(iv.getLookup(), split[LocalUtil.INBOUND_INDEX_TYPE], split[LocalUtil.INBOUND_INDEX_VALUE]);

                Object output = config.convertInbound(subtype, nested, inctx);
                col.add(output);
            }

            // If they wanted an Iterator then give them one otherwise use
            // the type we created
            if (Iterator.class.isAssignableFrom(paramType))
            {
                return col.iterator();
            }
            else
            {
                return col;
            }
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
        // First we need to get ourselves the collection data
        Iterator it = null;
        int size = -1;
        if (data instanceof Collection)
        {
            Collection col = (Collection) data;
            it = col.iterator();
            size = col.size();
        }
        else if (data instanceof Iterator)
        {
            it = (Iterator) data;
        }
        else
        {
            throw new ConversionException(Messages.getString("CollectionConverter.ConvertFailed", data.getClass().getName())); //$NON-NLS-1$
        }

        if (size == 0)
        {
            return new OutboundVariable("", "[]"); //$NON-NLS-1$ //$NON-NLS-2$
        }

        OutboundVariable ov = new OutboundVariable();
        String varname = outctx.getNextVariableName();
        ov.setAssignCode(varname);
        outctx.put(data, ov);

        // Convert all the data members
        List ovs = new ArrayList();
        int i = 0;
        while (it.hasNext())
        {
            Object member = it.next();
            OutboundVariable nested;
            try
            {
                nested = config.convertOutbound(member, outctx);
            }
            catch (Exception ex)
            {
                nested = new OutboundVariable("", "'Conversion Error. See console log.'"); //$NON-NLS-1$ //$NON-NLS-2$
                log.warn("Failed to convert array member " + i + ". Conversion error for type: " + data.getClass().getName(), ex); //$NON-NLS-1$ //$NON-NLS-2$
            }
            ovs.add(nested);
            i++;
        }

        ConverterUtil.addListInit(ov, ovs);
        return ov;
    }

    /**
     * For nested conversions
     */
    private ConverterManager config = null;

    /**
     * The log stream
     */
    private static final Logger log = Logger.getLogger(CollectionConverter.class);
}
