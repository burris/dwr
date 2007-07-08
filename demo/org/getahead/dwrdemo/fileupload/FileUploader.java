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
package org.getahead.dwrdemo.fileupload;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.directwebremoting.io.FileUpload;
import org.getahead.dwrdemo.util.ColorUtil;

/**
 * A demonstration of uploading files and images
 * @author Lance Semmens [uklance at gmail dot com]
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class FileUploader
{
    /**
     * Take 2 uploaded files and return an image based on them
     * @param uploadImage The uploaded image
     * @param uploadFile The uploaded file
     * @param color The selected color
     * @return A mangled image based on the 2 uploaded files
     */
    public BufferedImage uploadFiles(FileUpload uploadImage, FileUpload uploadFile, String color)
    {
        // Read the uploaded image, or create a blank if that fails
        BufferedImage image;
        try
        {
            InputStream in = uploadImage.getInputStream();
            image = ImageIO.read(in);
        }
        catch (IOException ex)
        {
            log.warn("Failed to decode uploaded image: Using blank canvas.", ex);
            image = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
        }

        // Read the uploaded file and treat it as text
        String text;
        try
        {
            InputStream in = uploadFile.getInputStream();
            byte[] buffer = new byte[1024];
            int len = in.read(buffer);
            text = new String(buffer, 0, len);
        }
        catch (IOException ex)
        {
            log.warn("Failed to read text form uploaded file", ex);
            text = ex.toString();
        }

        // Voodoo to scale the image to 200x200
        AffineTransform atx = new AffineTransform();
        atx.scale(200d / image.getWidth(), 200d / image.getHeight());
        AffineTransformOp afop = new AffineTransformOp(atx, AffineTransformOp.TYPE_BILINEAR);
        image = afop.filter(image, null);

        // And scrawl the text on the image in 10 rows of 20 chars
        for (int row = 0; row < 10; row++)
        {
            String output = null;
            if (text.length() > (row + 1) * 20)
            {
                output = text.substring(row * 20, (row + 1) * 20);
            }
            else
            {
                output = text.substring(row * 20);
            }

            Graphics2D g2d = image.createGraphics();
            g2d.setFont(new Font("SansSerif", Font.PLAIN, 16));
            g2d.setColor(ColorUtil.decodeHtmlColorString(color));
            g2d.drawString(output, 5, (row + 1) * 20);
        }

        return image;
    }

    /**
     * The log stream
     */
    private static final Log log = LogFactory.getLog(FileUploader.class);
}
