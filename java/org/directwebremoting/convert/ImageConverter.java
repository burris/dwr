/*
 * Copyright 2005 Joe Walker
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.directwebremoting.convert;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.directwebremoting.WebContextFactory;
import org.directwebremoting.dwrp.SimpleOutboundVariable;
import org.directwebremoting.extend.DownloadManager;
import org.directwebremoting.extend.InboundContext;
import org.directwebremoting.extend.InboundVariable;
import org.directwebremoting.extend.MarshallException;
import org.directwebremoting.extend.OutboundContext;
import org.directwebremoting.extend.OutboundVariable;
import org.directwebremoting.impl.DataUrlDownloadManager;

/**
 * An {@link ImageConverter} converts anything that extends {@link BufferedImage}
 * to a PNG/JPG etc on the client.
 * @author Jose Noheda [jose dot noheda at gmail dot com]
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class ImageConverter extends BaseV20Converter
{
    /* (non-Javadoc)
     * @see org.directwebremoting.extend.Converter#convertInbound(java.lang.Class, org.directwebremoting.extend.InboundVariable, org.directwebremoting.extend.InboundContext)
     */
    public Object convertInbound(Class<?> aClass, InboundVariable inboundVariable, InboundContext inboundContext) throws MarshallException
    {
        throw new UnsupportedOperationException();
    }

    /* (non-Javadoc)
     * @see org.directwebremoting.extend.Converter#convertOutbound(java.lang.Object, org.directwebremoting.extend.OutboundContext)
     */
    public OutboundVariable convertOutbound(Object object, OutboundContext outboundContext) throws MarshallException
    {
        if (object == null)
        {
            return new SimpleOutboundVariable("null", outboundContext, true);
        }

        try
        {
            BufferedImage image = (BufferedImage) object;
            ImageIOFileGenerator generator = new ImageIOFileGenerator(image);

            DownloadManager downloadManager;
            if (preferDataUrlSchema && isDataUrlAvailable())
            {
                downloadManager = new DataUrlDownloadManager();
            }
            else
            {
                downloadManager = WebContextFactory.get().getContainer().getBean(DownloadManager.class);
            }

            String url = downloadManager.addFile(generator);
            return new SimpleOutboundVariable(url, outboundContext, true);
        }
        catch (IOException ex)
        {
            throw new MarshallException(getClass(), ex);
        }
    }

    /**
     * Is the data: URL allowed by the current browser.
     * @return true if data: is allowed
     */
    protected boolean isDataUrlAvailable()
    {
        HttpServletRequest request = WebContextFactory.get().getHttpServletRequest();
        return request.getHeader("user-agent").indexOf("MSIE") == -1;
    }

    /**
     * Do we use a data: URL when we know it will work
     * @param preferDataUrlSchema
     */
    public void setPreferDataUrlSchema(boolean preferDataUrlSchema)
    {
        this.preferDataUrlSchema = preferDataUrlSchema;
    }

    /**
     * A way to convert {@link BufferedImage}s to files so they can be written
     * using a FileServingServlet or similar.
     */
    protected class ImageIOFileGenerator implements DownloadManager.FileGenerator
    {
        /**
         * Setup the image to convert
         * @param image the image to convert
         */
        public ImageIOFileGenerator(BufferedImage image)
        {
            this.image = image;
        }

        /* (non-Javadoc)
         * @see org.directwebremoting.extend.DownloadManager.FileGenerator#generateFile(java.io.OutputStream)
         */
        public void generateFile(OutputStream out) throws IOException
        {
            ImageIO.write(image, "png", out);
        }

        /* (non-Javadoc)
         * @see org.directwebremoting.extend.DownloadManager.FileGenerator#getMimeType()
         */
        public String getMimeType()
        {
            return "image/png";
        }

        /* (non-Javadoc)
         * @see org.directwebremoting.extend.DownloadManager.FileGenerator#getExtension()
         */
        public String getExtension()
        {
            return "png";
        }

        /**
         * The image that we are about to export
         */
        private final BufferedImage image;
    }

    /**
     * Do we use data: URLs when we can?
     */
    private boolean preferDataUrlSchema = true;
}
