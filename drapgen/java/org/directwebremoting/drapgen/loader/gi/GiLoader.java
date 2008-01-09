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
package org.directwebremoting.drapgen.loader.gi;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import nu.xom.Attribute;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.Nodes;

import org.directwebremoting.drapgen.ast.Constructor;
import org.directwebremoting.drapgen.ast.Field;
import org.directwebremoting.drapgen.ast.Method;
import org.directwebremoting.drapgen.ast.Parameter;
import org.directwebremoting.drapgen.ast.Project;
import org.directwebremoting.drapgen.ast.Type;
import org.directwebremoting.drapgen.loader.Loader;
import org.directwebremoting.drapgen.util.XomHelper;
import org.directwebremoting.drapgen.util.XomHelper.ElementBlock;
import org.directwebremoting.fsguide.FileSystemGuide;
import org.directwebremoting.fsguide.Visitor;
import org.directwebremoting.util.Logger;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class GiLoader implements Loader
{
    /**
     * @param source Where we read the API XML source from
     */
    public GiLoader(File source) throws Exception
    {
        log.info("Loading GI API from: " + source.getCanonicalPath());
        load(source);
    }

    /**
     * @param source Where we read the API XML source from
     */
    protected void load(File source) throws Exception
    {
        loadGiClasses(source);

        // markSuperClasses();
        // copyMixinFunctions();
        // trimDuplicateMethods();
    }

    /**
     * Load the GI XML files into a map of loaded XOM documents
     * @param directory The source of GI XML files
     */
    protected void loadGiClasses(final File directory)
    {
        types = new HashMap<String, Document>();

        // Create a list of all the classes we need to generate
        log.info("Searching for XML files.");
        FileSystemGuide guide = new FileSystemGuide(directory);
        guide.visit(new Visitor()
        {
            public void visitFile(File file)
            {
                try
                {
                    if (!file.getAbsolutePath().endsWith(".xml"))
                    {
                        log.info("Skipping: " + file.getAbsolutePath());
                        return;
                    }

                    String className = file.getAbsolutePath()
                        .substring(directory.getAbsolutePath().length() + 1)
                        .replaceFirst("\\.xml$", "")
                        .replace("/", ".");

                    Document doc = builder.build(file);

                    types.put(className, doc);
                }
                catch (Exception ex)
                {
                    throw new RuntimeException(ex);
                }
            }

            public boolean visitDirectory(File dir)
            {
                return true;
            }
        });
    }

    /**
     * Work out which classes are super-classes and mixins
     */
    protected void markSuperClasses()
    {
        log.info("Calculating super classes.");
        for (Document doc : types.values())
        {
            for (String superClass : getSuperClasses(doc))
            {   
                Document childDoc = types.get(superClass);
                childDoc.getRootElement().addAttribute(new Attribute("superClass", "true"));
            }
        }
    }

    /**
     * Find the super class names listed in the given document.
     * Perhaps this should be cached somewhere???
     * @param doc The document to search in
     * @return The list of found super classes
     */
    protected List<String> getSuperClasses(Document doc)
    {
        List<String> superClasses = new ArrayList<String>();
        Nodes superClassNodes = doc.query("/class/superclass/@name");
        for (int i = 0; i < superClassNodes.size(); i++)
        {
            superClasses.add(superClassNodes.get(i).getValue());
        }
        return superClasses;
    }

    /**
     * Copying mixin functions because Java does not do MI
     * @throws InterruptedException If the threading breaks
     */
    protected void copyMixinFunctions() throws InterruptedException
    {
        log.info("Copying mixin functions.");
        ExecutorService exec = Executors.newFixedThreadPool(2);

        for (final Map.Entry<String, Document> entry : types.entrySet())
        {
            exec.execute(new Runnable()
            {
                public void run()
                {
                    String className = entry.getKey();
                    Document doc = entry.getValue();

                    // Search the XML for lines like this from Button.xml:
                    //   <implements direct="1" id="implements:0" loaded="1" name="jsx3.gui.Form"/>

                    // Find all the inherited functions, and trim the ones that are not
                    // from super-classes - leaving the mixins
                    Nodes inheritedNodes = doc.query("/class/method[@inherited='1']");

                    for (int i = 0; i < inheritedNodes.size(); i++)
                    {
                        Element inheritedNode = (Element) inheritedNodes.get(i);
                        String name = inheritedNode.getAttributeValue("name");
                        if (name == null)
                        {
                            throw new NullPointerException("Missing name attribute from element: " + inheritedNode);
                        }

                        // We might be implemented elsewhere
                        String declarationClassName = inheritedNode.getAttributeValue("source");
                        if (declarationClassName == null)
                        {
                            declarationClassName = className;
                        }

                        boolean isFunctionFromMixin = true;
                        for (String superClass : getSuperClasses(doc))
                        {
                            if (declarationClassName.equals(superClass))
                            {
                                isFunctionFromMixin = false;
                            }
                        }

                        if (isFunctionFromMixin)
                        {
                            // replace the method element with the corresponding element from Form.
                            if (!"jsx3.lang.Object".equals(declarationClassName))
                            {
                                Nodes nodes = doc.query("/class/method[@name='" + name + "']");
                                if (nodes.size() != 1)
                                {
                                    throw new IllegalArgumentException("query returned wrong number of results");
                                }

                                Element newMethod = (Element) nodes.get(0);
                                inheritedNode.getParent().replaceChild(inheritedNode, newMethod);
                            }
                        }
                    }
                }
            });
        }
        exec.shutdown();
        exec.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
    }

    /**
     * Remove functions implemented by parent
     * @throws InterruptedException If the threading breaks
     */
    protected void trimDuplicateMethods() throws InterruptedException
    {
        log.info("Trimming methods with identical implementation in parent.");
        ExecutorService exec = Executors.newFixedThreadPool(2);
        for (final Document doc : types.values())
        {
            exec.execute(new Runnable()
            {
                public void run()
                {
                    // Get a list of super classes
                    final List<Document> parents = new ArrayList<Document>();
                    for (String superClassName : getSuperClasses(doc))
                    {
                        Document parent = types.get(superClassName);
                        if (parent == null)
                        {
                            throw new IllegalStateException("Unknown superclass: " + superClassName);
                        }
                        parents.add(parent);
                    }
        
                    // Find all the inherited functions, and trim the ones that are not
                    // from super-classes - leaving the mixins
                    XomHelper.query(doc, "/class/method[not(@inherited)]", new ElementBlock()
                    {
                        public void use(final Element inherited)
                        {
                            final String inheritedName = inherited.getAttributeValue("name");

                            // Loop over signatures, checking for methods in super-classes
                            for (Document parent : parents)
                            {
                                XomHelper.query(parent, "/class/method[not(@inherited)]", new ElementBlock()
                                {
                                    public void use(Element parentMethod)
                                    {
                                        if (inherited.getParent() == null)
                                        {
                                            return;
                                        }

                                        String parentMethodName = parentMethod.getAttributeValue("name");
                                        if (inheritedName.equals(parentMethodName))
                                        {
                                            inherited.getParent().removeChild(inherited);
                                        }
                                    }
                                });
                            }
                        }
                    });
                }
            });
        }

        exec.shutdown();
        exec.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
    }

    /* (non-Javadoc)
     * @see org.directwebremoting.drapgen.loader.Loader#loadToProject(org.directwebremoting.drapgen.ast.Project)
     */
    public void loadToProject(final Project project)
    {
        log.info("Copying data to project");
        SortedSet<String> keys = new TreeSet<String>(types.keySet());
        for (String className : keys)
        {
            log.info("  " + className);

            String alternate = checkAlternativeNames(className);
            if (!alternate.equals(className))
            {
                log.info("    Skipping: has a local version - " + alternate);
                continue;
            }

            // Remove documentation classes like index.java, package-summary.java, etc
            if (className.endsWith("index") ||
                className.endsWith("inheritance") ||
                className.endsWith("package-summary"))
            {
                log.info("    Skipping: it's documentation");
                continue;
            }

            Element root = types.get(className).getRootElement();
            if (root.getAttributeValue("deprecated") != null)
            {
                deprecatedTypes.add(className);
                log.info("    Skipping: it's deprecated");
                continue;
            }

            final Type type = getType(project, className);
            String typeDocs = readDocumentation(root);
            type.setDocumentation(typeDocs);

            String superClassName = XomHelper.queryValue(root, "superclass[@direct='1']/@name");
            if (superClassName != null)
            {
                type.setSuperClass(getType(project, superClassName));
            }

            XomHelper.getChildElements(root, "implements", new ElementBlock()
            {
                public void use(Element implementsElement)
                {
                    String direct = implementsElement.getAttributeValue("direct");
                    if (direct == null || !direct.equals("1"))
                    {
                        return;
                    }

                    String interfaceName = implementsElement.getAttributeValue("name");
                    if (interfaceName == null)
                    {
                        log.warn("    Skipping direct implements element with no name");
                    }
                    type.addInterface(getType(project, interfaceName));
                }
            });

            // Find all the constructors that we're interested in
            XomHelper.getChildElements(root, "constructor", new ElementBlock()
            {
                public void use(Element ctorElement)
                {
                    if (ctorElement.getAttribute("deprecated") != null)
                    {
                        return;
                    }

                    // Read a set of param elements attached to a constructor or method

                    String documentation = readDocumentation(ctorElement);
                    Set<List<Parameter>> parameters = getGiParamList(ctorElement, "ctor", project);
                    for (List<Parameter> parameter : parameters)
                    {
                        Constructor constructor = type.createConstructor();
                        constructor.setDocumentation(documentation);
                        constructor.setParameters(parameter);
                    }
                }
            });

            // Find all the methods that we're interested in
            XomHelper.getChildElements(root, "method", new ElementBlock()
            {
                public void use(Element methodElement)
                {
                    if (methodElement.getAttribute("deprecated") != null)
                    {
                        return;
                    }

                    if (methodElement.getAttribute("inherited") != null)
                    {
                        return;
                    }

                    String methodName = methodElement.getAttributeValue("name");
                    String documentation = readDocumentation(methodElement);
                    Type returnType = readGiReturnType(methodElement, project, methodName);

                    // Read a set of param elements attached to a constructor or method

                    Set<List<Parameter>> parameters = getGiParamList(methodElement, methodName, project);
                    for (List<Parameter> parameter : parameters)
                    {
                        Method method = type.createMethod();
                        method.setDocumentation(documentation);
                        method.setName(methodName);
                        method.setType(returnType);
                        method.setParameters(parameter);
                    }
                }
            });

            XomHelper.getChildElements(root, "field", new ElementBlock()
            {
                public void use(Element fieldElement)
                {
                    if (fieldElement.getAttribute("deprecated") != null)
                    {
                        return;
                    }

                    String statc = fieldElement.getAttributeValue("static");
                    if (statc == null || !statc.equals("1"))
                    {
                        return;
                    }

                    String access = fieldElement.getAttributeValue("access");
                    if (access == null || !access.equals("public"))
                    {
                        return;
                    }

                    String name = fieldElement.getAttributeValue("name");

                    Field field = type.createConstant();
                    field.setDocumentation(fieldElement.getAttributeValue("text"));
                    field.setName(name);
                    field.setValue(fieldElement.getAttributeValue("value"));

                    Elements typeElements = fieldElement.getChildElements("type");
                    if (typeElements.size() == 0)
                    {
                        log.warn("    ." + name + "(): Missing return element. Using Object.");
                        field.setType(getType(project, "java.lang.Object"));
                    }
                    else
                    {
                        if (typeElements.size() > 1)
                        {
                            log.warn("    ." + name + "(): More than one type element. Using first.");
                        }

                        Element typeElement = typeElements.get(0);
                        String typeName = typeElement.getAttributeValue("name");
                        field.setType(getType(project, typeName));
                    }
                }
            });
        }

        // We need to remove the classes that we don't want to generate
        Set<Type> toDelete = new HashSet<Type>();
        for (Type type : project.getTypes())
        {
            if (!type.getPackageName().startsWith("jsx3"))
            {
                toDelete.add(type);
            }
        }
        for (Type type : toDelete)
        {
            project.remove(type);
        }
    }

    /**
     * We want to alter the names of some classes as we generate them
     * @param project The project that we use to lookup Types
     * @param className The name of the requested class
     * @return A Type representing the name altered type
     */
    protected Type getType(Project project, String className)
    {
        if (isDeprecated(className))
        {
            log.warn("Request for deprecated type: " + className);
            return project.getType("jsx3.lang.Unavailable");
        }

        String name = checkAlternativeNames(className);

        return project.getType(name);
    }

    /**
     * @param className The name to check for deprecation
     * @return true if the type has been deprecated
     */
    protected boolean isDeprecated(String className)
    {
        for (String deprecatedType : deprecatedTypes)
        {
            if (className.equals(deprecatedType))
            {
                return true;
            }
        }

        return false;
    }

    /**
     * We might need to use differing versions of class names
     */
    protected String checkAlternativeNames(String className)
    {
        for (String[] pairs : classNameSwaps)
        {
            if (className.equals(pairs[0]))
            {
                return pairs[1];
            }
        }
        return className;
    }

    /**
     * 
     */
    private static final String[][] classNameSwaps = new String[][]
    {
        { "", "java.lang.Object" },
        { "Object", "java.lang.Object" },
        { "Date", "java.util.Date" },
        { "Iterator", "java.util.Iterator" },
        { "Math", "jsx3.lang.Unavailable" },
        { "RegExp", "jsx3.lang.Unavailable" },
        { "Number", "Integer" },
        { "String", "java.lang.String" },
        { "Array", "Object[]" },
        { "Boolean", "java.lang.Boolean" },
        { "Function", "org.directwebremoting.proxy.CodeBlock" },
        { "HTMLElement", "String" },
        { "HTMLDocument", "String" },
        { "VectorStroke", "String" },
        { "jsx3.Boolean", "Boolean" },
        { "jsx3.app.Properties", "java.util.Properties" },
        { "jsx3.lang.Class", "java.lang.Class" },
        { "jsx3.lang.ClassLoader", "java.lang.ClassLoader" },
        { "jsx3.lang.Exception", "Exception" },
        { "jsx3.lang.IllegalArgumentException", "IllegalArgumentException" },
        { "jsx3.util.Logger", "jsx3.lang.Unavailable" },
        { "jsx3.util.Logger.Record", "jsx3.lang.Unavailable" },
    };

    /**
     * Read the text child element and set the drapgen AST element with it's
     * content
     * @param xomElement the XML element to read from
     */
    protected String readDocumentation(Element xomElement)
    {
        Element textElement = xomElement.getFirstChildElement("text");
        if (textElement != null)
        {
            return textElement.getValue();
        }
        else
        {
            return null;
        }
    }

    /**
     * Read a set of param elements attached to a constructor or method
     * @param element The XOM element to read from
     * @param debugName
     * @param project
     * @return A list of found parameters
     */
    protected Set<List<Parameter>> getGiParamList(Element element, final String debugName, final Project project)
    {
        // The types used by this method are somewhat funky. We first create a
        // list of parameters with the alternative types for each in a stack.
        // We then need to return a set where all the different combinations of
        // these alternatives are represented. We use Set<List<>> and
        // List<Stack<>> to help make it clearer what we are working on.

        // So GI has a list of parameters for this subroutine. Each parameter
        // has a set of types that it can be
        final List<Stack<Parameter>> parametersWithOptions = new ArrayList<Stack<Parameter>>();
        XomHelper.getChildElements(element, "param", new ElementBlock()
        {
            public void use(Element paramElement)
            {
                String documentation = paramElement.getAttributeValue("text");
                String name = paramElement.getAttributeValue("name");

                Set<Type> alternatives = new HashSet<Type>();

                Elements typeElements = paramElement.getChildElements("type");
                if (typeElements.size() == 0)
                {
                    log.warn("    ." + debugName + "(): Missing type element for parameter '" + name + "'. Assuming Object.");
                    alternatives.add(getType(project, "java.lang.Object"));
                }
                else
                {
                    for (int i = 0; i < typeElements.size(); i++)
                    {
                        Element typeElement = typeElements.get(i);
                        String typeName = typeElement.getAttributeValue("name");
                        alternatives.add(getType(project, typeName));
                    }
                }

                Stack<Parameter> p = new Stack<Parameter>();
                for (Type alternative : alternatives)
                {
                    Parameter parameter = new Parameter(project);
                    parameter.setDocumentation(documentation);
                    parameter.setName(name);
                    parameter.setType(alternative);
                    p.add(parameter);
                }

                parametersWithOptions.add(p);
            }
        });

        Set<List<Parameter>> parameterCombinations = new HashSet<List<Parameter>>();

        if (parametersWithOptions.size() > 0)
        {
            recurseOverTypesInParameter(parametersWithOptions, 0, new LinkedList<Integer>(), parameterCombinations);
        }
        else
        {
            // There is one combination - that with no parameters
            parameterCombinations.add(new ArrayList<Parameter>());
        }

        return parameterCombinations;
    }

    /**
     * @param parametersWithOptions
     * @param paramNumber
     * @param combinations
     */
    private void recurseOverTypesInParameter(List<Stack<Parameter>> parametersWithOptions, int paramNumber, LinkedList<Integer> typeList, Set<List<Parameter>> combinations)
    {
        // We do *something* for each of the alternatives in the set of
        // parameters for this type
        Stack<Parameter> alternatives = parametersWithOptions.get(paramNumber);
        for (int i = 0; i < alternatives.size(); i++)
        {
            LinkedList<Integer> nextTypeList = new LinkedList<Integer>(typeList);
            nextTypeList.add(i);

            if (paramNumber == parametersWithOptions.size() - 1)
            {
                // If this is the last parameter then *something* is creating
                // an entry in the output set
                List<Parameter> combination = new ArrayList<Parameter>();
                for (int paramIndex = 0; paramIndex < nextTypeList.size(); paramIndex++)
                {
                    Integer selection = nextTypeList.get(paramIndex);
                    Parameter selected = parametersWithOptions.get(paramIndex).get(selection);
                    combination.add(selected);
                }
                combinations.add(combination);
            }
            else
            {
                // If this is not the last parameter then *something* is to call
                // ourself to loop over the options for the next parameter
                recurseOverTypesInParameter(parametersWithOptions, paramNumber + 1, nextTypeList, combinations);
            }
        }
    }

    /**
     * Read a return type element attached to a method.
     * For some reason calling method.toString as part of the log.warn messages
     * crashes the VM on mac-os. Why???
     * @param element The XOM element to read from
     */
    protected Type readGiReturnType(Element element, Project project, final String name)
    {
        //Project project = method.getParent().getProject();
        Elements returnElements = element.getChildElements("return");
        if (returnElements.size() == 0)
        {
            return getType(project, "void");
        }
        else
        {
            if (returnElements.size() > 1)
            {
                log.warn("    ." + name + "(): More than one return element. Using first.");
            }

            Element returnElement = returnElements.get(0);
            Elements typeElements = returnElement.getChildElements("type");
            if (typeElements.size() == 0)
            {
                log.warn("    ." + name + "(): Missing return element. Using Object.");
                return getType(project, "java.lang.Object");
            }
            else
            {
                if (typeElements.size() > 1)
                {
                    log.warn("    ." + name + "(): More than one type element. Using first.");
                }

                Element typeElement = typeElements.get(0);
                String typeName = typeElement.getAttributeValue("name");
                return getType(project, typeName);
            }
        }
    }

    /**
     * What classes have been deprecated?
     */
    protected Set<String> deprecatedTypes = new HashSet<String>();

    /**
     * Our cache of loaded GI documents
     */
    protected Map<String, Document> types;

    /**
     * The XOM document builder
     */
    protected Builder builder = new Builder();

    /**
     * The log stream
     */
    protected static final Logger log = Logger.getLogger(GiLoader.class);
}
