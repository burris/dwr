/**
 * <p>
 *   This package provides support for Guice dependency injection in DWR-based
 *   web applications. To use this support minimally,
 *   <ol>
 *   <li> install a concrete extension of {@link DwrGuiceServletContextListener}
 *     as a <code>&lt;listener&gt;</code> in your web application's configuration
 *     file (web.xml), </li>
 *   <li> install {@link com.google.inject.servlet.GuiceFilter} as a filter
 *     for all requests, and </li>
 *   <li> install {@link DwrGuiceServlet} for all requests to <code>/dwr/*</code>. </li>
 *   </ol>
 * </p>
 * <p>
 *   Your listener class will have define a <code>configure</code> method.
 *   This is where to do your Guice binding, since DwrGuiceServletContextListener
 *   extends AbstractDwrModule, which in turn extends Guice's AbstractModule. You
 *   can move the binding code to a separate class by using
 *   {@link AbstractModule#install AbstractModule.install(Module module)}.
 * </p>
 * <p>
 *   You can configure DWR normally via dwr.xml and servlet init params,
 *   but you can also configure some aspects by calling the methods of
 *   AbstractDwrModule in your Guice binding code. You can install your
 *   own DWR Configurator in this way, and use a FluentConfigurator (or
 *   GuiceConfigurator, which extends FluentConfigurator with methods that
 *   provide additional type-safety).
 * </p>
 * <p>
 *   When you use a GuiceCreator to create your remote proxies, it gets
 *   an instance from the Injector using your bindings.
 * </p>
 * <p>
 *   A sample web.xml with the parts listed above:
 * </p>
 * <pre>
 *   &lt;listener&gt;
 *     &lt;listener-class&gt;org.myorg.myproj.MyServletContextListener&lt;/listener-class&gt;
 *   &lt;/listener&gt;
 *
 *   &lt;filter&gt;
 *     &lt;filter-name&gt;guice-filter&lt;/filter-name&gt;
 *     &lt;filter-class&gt;com.google.inject.servlet.GuiceFilter&lt;/filter-class&gt;
 *   &lt;/filter&gt;
 *
 *   &lt;filter-mapping&gt;
 *     &lt;filter-name&gt;guice-filter&lt;/filter-name&gt;
 *     &lt;servlet-name&gt;dwr-invoker&lt;/servlet-name&gt;
 *   &lt;/filter-mapping&gt;
 *
 *   &lt;servlet&gt;
 *     &lt;servlet-name&gt;dwr-invoker&lt;/servlet-name&gt;
 *     &lt;servlet-class&gt;org.directwebremoting.guice.DwrGuiceServlet&lt;/servlet-class&gt;
 *   &lt;/servlet&gt;
 *
 *   &lt;servlet-mapping&gt;
 *     &lt;servlet-name&gt;dwr-invoker&lt;/servlet-name&gt;
 *     &lt;url-pattern&gt;/dwr/*&lt;/url-pattern&gt;
 *   &lt;/servlet-mapping&gt;
 * </pre>
 * <p>
 *   An example of pure Java configuration via Guice:
 * </p>
 * <pre>
 *
 *   public final class MyServletContextListener extends DwrGuiceServletContextListener
 *   {
 *       protected void configure()
 *       {
 *           bind(MessageService.class)
 *               .to(MessageServiceImpl.class)
 *               .in(ServletScopes.SESSION);
 *
 *           setDebug(true);
 *
 *           setAnnotatedClasses(
 *               DomainService.class,
 *               HelloService.class,
 *               HelloRecord.class
 *           );
 *
 *           setConfiguratorClass(LocalConfigurator.class);
 *       }
 *
 *       public static class LocalConfigurator extends GuiceConfigurator
 *       {
 *           public void configure()
 *           {
 *               withConverterType(DATE_TIME_CONVERTER, DateTimeConverter.class);
 *               withConverter(DATE_TIME_CONVERTER, DateTime.class)
 *                   .addParam("format", "yyyy-MM-dd hh:mm a");
 *               withConverter(DATE_TIME_CONVERTER, LocalTime.class)
 *                   .addParam("format", "yyyy-MM-dd");
 *           }
 *       }
 *
 *       private static final String DATE_TIME_CONVERTER = "dateTime";
 *   }
 * </pre>
 * <p>
 *   In this example, the <code>DomainService</code> and <code>HelloService</code>
 *   classes would need to be annotated with
 *   <code>@RemoteProxy(creator=GuiceCreator.class)</code>
 *   and the <code>HelloRecord</code> class would need to be annotated with
 *   <code>@DataTransferObject</code>.
 * </p>
 */
package org.directwebremoting.guice;
