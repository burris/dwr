package org.getahead.dwrdemo.cli;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.nio.SelectChannelConnector;
import org.mortbay.jetty.webapp.WebAppContext;

/**
 * JettyLauncher.
 */
public class JettyLauncher
{
    /**
     * Sets up and runs server.
     * @param args
     */
    public static void main(String[] args)
    {
        Server server = new Server();

        SelectChannelConnector connector = new SelectChannelConnector();
        connector.setPort(8080);
        server.addConnector(connector);
        server.setStopAtShutdown(true);

        server.addHandler(new WebAppContext("web","/dwr"));

        server.addHandler(new WebAppContext("test","/dwr-test"));
    }
}
