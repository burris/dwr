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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.directwebremoting.drapgen.xslt.ExtensionFunctions;
import org.directwebremoting.fsguide.FileSystemGuide;
import org.directwebremoting.fsguide.Visitor;
import org.w3c.dom.Node;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class Generate
{
    public static final String XML_BASE = "/Applications/TIBCO/tibco-gi-3.5-pro-src/dist/gi/api/xml/";
    public static final String GENERATED_BASE = "generated/gi/java/org/directwebremoting/proxy/";
    public static final String TEMPLATES_BASE = "etc/drapgen/templates/";
    public static final String DEFAULT_TEMPLATE = "default.xslt";
    public static final String PREPROCESSOR = "etc/drapgen/preprocess/default.xslt";

    public static void main(String[] args) throws Exception
    {
        new Generate().generate();
    }

    public void generate() throws Exception
    {
        // Create a list of all the classes we need to generate
        log.info("Searching for XML files.");
        FileSystemGuide guide = new FileSystemGuide(new File(XML_BASE));
        guide.visit(new Visitor()
        {
            public void visitFile(File file)
            {
                if (file.getAbsolutePath().endsWith(".xml"))
                {
                    SourceCode code = new SourceCode(file);
                    sources.put(code.getClassName(), code);
                }
                else
                {
                    log.info("Skipping: " + file.getAbsolutePath());
                }
            }

            public boolean visitDirectory(File directory)
            {
                return true;
            }
        });
        ExtensionFunctions.setGenerate(this);

        // Clone the functions with multiple input parameter types for overloading
        log.info("Cloning for overloading.");
        for (SourceCode code : sources.values())
        {
            code.cloneForOverloading();
        }
        
        // Work out which classes are super-classes and mixins
        log.info("Calculating super classes.");
        for (SourceCode code : sources.values())
        {
            List<String> parents = code.getSuperClasses();
            for (String parent : parents)
            {
                sources.get(parent).setSuperClass(true);
            }
        }

        // Copying mixin functions because Java does not do MI
        log.info("Copying mixin functions.");
        ExecutorService exec = Executors.newFixedThreadPool(2);
        for (final SourceCode code : sources.values())
        {
            exec.execute(new Runnable()
            {
                public void run()
                {
                    // Search the XML for lines like this from Button.xml:
                    //   <implements direct="1" id="implements:0" loaded="1" name="jsx3.gui.Form"/>
                    List<Pair<String, String>> mixinFunctions = code.getMixinFunctions();
                    for (Pair<String, String> mixinFunction : mixinFunctions)
                    {
                        // replace the method element with the corresponding element from Form.
                        if (!"jsx3.lang.Object".equals(mixinFunction.left))
                        {
                            SourceCode implementingClass = sources.get(mixinFunction.left);
                            Node node = implementingClass.getImplementationDeclaration(mixinFunction.right);
                            if (node == null)
                            {
                                log.warn("- No implementation of: " + mixinFunction.left + "." + mixinFunction.right + "() refered to by " + code.getClassName());
                            }
                            else
                            {
                                // log.info("- Promoting: " + mixinFunction.left + "." + mixinFunction.right + "() into " + code.getClassName());
                                code.replaceImplementation(mixinFunction.right, node);
                            }
                        }
                    }
                }
            });
        }

        exec.shutdown();
        exec.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);

        // Transform them all
        log.info("Transforming " + sources.size() + " classes.");
        for (SourceCode code : sources.values())
        {
            code.transform();
        }

        // Merge Inner Classes
        log.info("Merging Inner Classes");
        for (Iterator<Map.Entry<String, SourceCode>> it = sources.entrySet().iterator(); it.hasNext();)
        {
            Map.Entry<String, SourceCode> entry = it.next();
            String className = entry.getKey();
            String parentName = "";

            int lastDot = className.lastIndexOf('.');
            if (lastDot > 0)
            {
                parentName = className.substring(0, lastDot);
            }

            SourceCode parent = sources.get(parentName);
            if (parent != null)
            {
                it.remove();
                parent.absorbClass(entry.getValue());
            }
        }

        // Write them to disk
        log.info("Writing " + sources.size() + " classes.");
        for (SourceCode code : sources.values())
        {
            code.write();
        }
    }

    /**
     * Accessor for the list of sources
     */
    public Map<String, SourceCode> getSources()
    {
        return sources;
    }

    protected final Map<String, SourceCode> sources = new HashMap<String, SourceCode>();

    /**
     * The log stream
     */
    protected static final Log log = LogFactory.getLog(Generate.class);
}
