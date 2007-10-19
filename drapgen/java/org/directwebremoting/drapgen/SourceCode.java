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
package org.directwebremoting.drapgen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.SourceLocator;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class SourceCode
{
    /**
     * @param xmlFile The GI doc description file to read
     */
    public SourceCode(File xmlFile)
    {
        FileInputStream in = null;

        try
        {
            DocumentBuilder docBuilder = Generate.builderFactory.newDocumentBuilder();
            in = new FileInputStream(xmlFile);
            document = docBuilder.parse(in);
            this.xmlFile = xmlFile;
            xmlClassName = xmlFile.getAbsolutePath().substring(Generate.XML_BASE.length());
            className = xmlClassName.replaceFirst("\\.xml$", "").replace("/", ".");
            // Setup the outputs
            String javaClassName = xmlClassName.replaceFirst("\\.xml$", ".java");
            javaFile = new File(Generate.GENERATED_BASE + javaClassName);
            javaParentDir = javaFile.getParentFile();
            output = new StringWriter();
        }
        catch (Exception ex)
        {
            throw new RuntimeException(ex);
        }
        finally
        {
            if (in != null)
            {
                try
                {
                  in.close();
                }
                catch (Exception ex)
                {
                    /* ignore exception */
                }
            }
        }
    }

    /**
     *
     */
    public void cloneForOverloading()
    {
        try
        {
            Source xmlSource = new DOMSource(document);

            DocumentBuilder builder = Generate.builderFactory.newDocumentBuilder();
            Document newDocument = builder.newDocument();
            Result result = new DOMResult(newDocument);

            xformer.transform(xmlSource, result);
            document = newDocument;
        }
        catch (TransformerException ex)
        {
            SourceLocator locator = ex.getLocator();
            log.warn("Line: " + locator.getLineNumber() + ", Column: " + locator.getColumnNumber());
            log.warn("PublicId: " + locator.getPublicId());
            log.warn("SystemId: " + locator.getSystemId());
            log.error("Failed to transform", ex);
        }
        catch (Exception ex)
        {
            log.warn("Processing Error for " + xmlFile.getAbsolutePath(), ex);
        }
    }

    /**
     *
     */
    public void transform()
    {
        try
        {
            File templateFile = new File(Generate.TEMPLATES_BASE + xmlClassName.replaceFirst("\\.xml$", ".xslt"));
            if (!templateFile.canRead())
            {
                templateFile = new File(Generate.TEMPLATES_BASE + Generate.DEFAULT_TEMPLATE);
            }

            // Read the XSLT
            Source xslSource = new StreamSource(templateFile);

            Templates template = templatesCache.get(templateFile);
            if (template == null)
            {
                template = Generate.factory.newTemplates(xslSource);
                templatesCache.put(templateFile, template);
            }

            Source xmlSource = new DOMSource(document);
            xformer.transform(xmlSource, new StreamResult(output));
        }
        catch (TransformerException ex)
        {
            SourceLocator locator = ex.getLocator();
            log.warn("Line: " + locator.getLineNumber() + ", Column: " + locator.getColumnNumber());
            log.warn("PublicId: " + locator.getPublicId());
            log.warn("SystemId: " + locator.getSystemId());
            log.fatal("Failed to transform", ex);
        }
        catch (Exception ex)
        {
            log.warn("Processing Error for " + xmlFile.getAbsolutePath(), ex);
        }
    }

    /**
     * @throws java.io.IOException If writing fails
     */
    public void write() throws IOException
    {
        if (!javaParentDir.isDirectory())
        {
            if (!javaParentDir.mkdirs())
            {
                throw new IOException("Failed to create directory: " + javaParentDir.getName());
            }
        }

        FileWriter out = null;

        try
        {
            StringBuffer outerCode = output.getBuffer();
            if (outerCode.toString().trim().length() != 0)
            {
                int closeCurly = outerCode.lastIndexOf("}");
                if (closeCurly != -1)
                {
                    outerCode.delete(closeCurly, outerCode.length() - 1);
                }

                out = new FileWriter(javaFile);
                out.append(outerCode);

                for (SourceCode innerSource : innerSources)
                {
                    String innerCode = innerSource.output.toString();
                    innerCode = innerCode.replaceAll("import .*;", "");
                    innerCode = innerCode.replaceAll("package .*;", "");
                    innerCode = innerCode.replaceAll(" " + getShortName() + "." + innerSource.getShortName(), " " + innerSource.getShortName());

                    out.append(innerCode);
                }

                if (closeCurly != -1)
                {
                    out.append("}\n");
                }
            }
        }
        finally
        {
            if (out != null)
            {
                out.close();
            }
        }
    }

    /**
     * @return A list of the names of this classes super-classes
     */
    public List<String> getSuperClasses()
    {
        try
        {
            List<String> reply = new ArrayList<String>();

            NodeList nodelist = (NodeList) superClassFinder.evaluate(document, XPathConstants.NODESET);

            for (int i = 0; i < nodelist.getLength(); i++)
            {
                Node node = nodelist.item(i);
                reply.add(node.getNodeValue());
            }

            return reply;
        }
        catch (XPathExpressionException ex)
        {
            throw new RuntimeException(ex);
        }
    }

    /**
     * @return Does this class have children?
     */
    public boolean isSuperClass()
    {
        return superclass;
    }

    /**
     * @param superclass Set the flag that this class has children
     */
    public void setSuperClass(boolean superclass)
    {
        this.superclass = superclass;
    }

    /**
     * @return The name of this class without package
     */
    private String getShortName()
    {
        int lastDot = className.lastIndexOf(".");
        return className.substring(lastDot + 1);
    }

    /**
     * @return The full name (including package)
     */
    public String getClassName()
    {
        return className;
    }

    /**
     * Add this given class to this class as an inner class
     * @param sourceCode The class to add an an inner class
     */
    public void absorbClass(SourceCode sourceCode)
    {
        innerSources.add(sourceCode);
    }

    /**
     * Search the XML for lines like this from Button.xml:
     *   <method id="method:setEnabled" idfk="method:setEnabled" inherited="1" name="setEnabled" source="jsx3.gui.Form"/>
     * @return A list of pairs: name|source
     */
    public List<Pair<String, String>> getMixinFunctions()
    {
        try
        {
            List<Pair<String, String>> reply = new ArrayList<Pair<String, String>>();

            NodeList nodelist = (NodeList) mixinFunctionFinder.evaluate(document, XPathConstants.NODESET);

            for (int i = 0; i < nodelist.getLength(); i++)
            {
                Node node = nodelist.item(i);
                String name = node.getAttributes().getNamedItem("name").getNodeValue();
                String source = node.getAttributes().getNamedItem("source").getNodeValue();
                reply.add(new Pair<String, String>(source, name));
            }

            return reply;
        }
        catch (XPathExpressionException ex)
        {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Find implementing functions
     *   <method access="public" id="method:setEnabled" name="setEnabled">...
     * @param name A method name to find in the input document
     * @return the node that matches the given name
     */
    public Node getImplementationDeclaration(String name)
    {
        try
        {
            XPathExpression implementationFinder = xpath.compile("//method[@name='" + name + "']");
            return (Node) implementationFinder.evaluate(document, XPathConstants.NODE);
        }
        catch (XPathExpressionException ex)
        {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Replace a stub with an implementation
     * @param name A method name to replace in the input document
     * @param element The element to replace the declaration with
     */
    public void replaceImplementation(String name, Node element)
    {
        Node oldChild = getImplementationDeclaration(name);
        Node cloned = element.cloneNode(true);
        Node newChild = document.adoptNode(cloned);
        oldChild.getParentNode().replaceChild(newChild, oldChild);
    }

    private String className;
    private File xmlFile;
    private String xmlClassName;
    private File javaFile;
    private File javaParentDir;
    private StringWriter output;
    private List<SourceCode> innerSources = new ArrayList<SourceCode>();
    private Document document;
    private boolean superclass = false;

    private static final Map<File, Templates> templatesCache = new HashMap<File, Templates>();

    private static final XPath xpath = XPathFactory.newInstance().newXPath();
    private static final XPathExpression superClassFinder;
    private static final XPathExpression mixinFunctionFinder;

    private static final Transformer xformer;

    /**
     * The log stream
     */
    private static final Log log = LogFactory.getLog(SourceCode.class);

    static
    {
        try
        {
            superClassFinder = xpath.compile("//superclass/@name");
            mixinFunctionFinder = xpath.compile("//method[@inherited='1']");

            // Read the XSLT
            Source xslSource = new StreamSource(new File(Generate.PREPROCESSOR));
            Templates template = Generate.factory.newTemplates(xslSource);
            xformer = template.newTransformer();
        }
        catch (RuntimeException ex)
        {
            throw ex;
        }
        catch (Exception ex)
        {
            throw new RuntimeException(ex);
        }
    }
}
