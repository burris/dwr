
DWR (Direct Web Remoting)
-------------------------

What does DWR do for you:
- Gives you a very very easy way to call Java code from your web-app.
- Gives you a jump-start to being able to create GMail type interactivity.

Steps to getting DWR running in your web app:

1. Copy the JAR file dwr.jar into the WEB-INF/lib directory of your webapp.

2. Add the following lines to your WEB-INF/web.xml

  <servlet>
    <servlet-name>dwr-invoker</servlet-name>
    <display-name>DWR Servlet</display-name>
    <description>Direct Web Remoter Servlet</description>
    <servlet-class>uk.ltd.getahead.dwr.DWRServlet</servlet-class>
      <init-param>
         <param-name>allowed</param-name>
         <param-value>com.mgrover.ngconfig.model.Actions uk.ltd.getahead.dwr.test.Test java.util.Date</param-value>
         <description>What classes do we allow access to?</description>
      </init-param>
      <load-on-startup>-1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>dwr-invoker</servlet-name>
    <url-pattern>/dwr/*</url-pattern>
  </servlet-mapping>

You can change the dwr-allowed parameter to specify any class you want, so long
as it satisfies the following:

- The class must have a public no-args constructor like any normal Java Bean
- Avoid classes called by reserved JavaScript words.
  (methods called by reserved words are automatically excluded)
- There must be a way of converting from a string to all the parameter types.
  Currently the Coercer class converts Strings and all primitive types.
- Overridden methods will be involved in a bit of a lottery as to which gets
  called, so avoid overridden methods.


3. Go to the following URL:

http://localhost:8080/[YOUR-WEBAPP-NAME]/dwr

You should see a page showing you the classes that you've selected in step 2.
Having followed a link you should see an index of all the methods all ready for
calling.
Kick the tyres and have a look around.


4. To see more of how it works add the following lines to your web.xml:

      <init-param>
         <param-name>debug</param-name>
         <param-value>true</param-value>
         <description>Do we begin in debug mode</description>
      </init-param>


5. How to make use of this from your web application

- Write some Java code that you would like to be executed from your webapp.
You don't need to use any special framework, just so long as your code follows
the restrictions in step 2.
- Go to http://localhost:8080/[YOUR-WEBAPP-NAME]/dwr and click on you class
- Do view source and find the <li> that executes the method that you are
  interested.
- Paste the text into an HTML or JSP page in your web-app.
- Include links to the javascript files that make the magic happen:
  <script type='text/javascript' src='/[YOUR-WEBAPP-NAME]/dwr/[YOUR-CLASS]/interface.js'></script>
  <script type='text/javascript' src='/[YOUR-WEBAPP-NAME]/dwr/engine.js'></script>
- You will probably need to customize the Javascript to fit your site.
- Dance the funky chicken.


6. THINK ABOUT SECURITY

There is a danger that you could cause all sorts of security problems using this
code. You need to think about security earlier rather than later.

It makes sense to write your classes with DWR in mind thinking about the
restrictions in step 2 above. Don't accidentally include methods that would
allow an attacker to do too more that you wanted.

Access to dwr can be restricted using the declaritive security built into the
servlet spec.


The JavaBeans you write will function a bit like Stateless Session EJBs. The
differences are:
- DWR has no complex deployment and can be run from Tomcat without needing a
  full EJB server
- DWR is called directly from JavaScript without needing a separate web framework
- DWR does not do transactions, security but there are 101 frameworks that will
  give you those things.
