package com.pasadya;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;

import org.eclipse.jetty.jmx.MBeanContainer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;

public class Start {

	  /**
	   * Main function, starts the jetty server.
	   *
	   * @param args
	   */
	  public static void main(String[] args) throws Exception {

	    Server server = new Server();
	    SelectChannelConnector connector = new SelectChannelConnector();
	    connector.setPort(8080);
	    server.addConnector(connector);

	    WebAppContext web = new WebAppContext();
	    web.setContextPath("/");
	    web.setWar("src/main/webapp");
	    server.setHandler(web);

	    MBeanServer mBeanServer = ManagementFactory
	        .getPlatformMBeanServer();
	    MBeanContainer mBeanContainer = new MBeanContainer(mBeanServer);
	    server.getContainer().addEventListener(mBeanContainer);
	    mBeanContainer.start();

	    try {
	      System.out.println(">>> STARTING EMBEDDED JETTY SERVER, PRESS ANY KEY TO STOP");
	      server.start();
	      while (System.in.available() == 0) {
	        Thread.sleep(5000);
	      }
	      server.stop();
	      server.join();
	    } catch (Exception e) {
	      e.printStackTrace();
	      System.exit(100);
	    }
	  }
	}