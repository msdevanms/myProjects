package edu.am.bigdata.controller.comm;

import org.apache.log4j.Logger;
import org.restlet.Component;
import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.ext.jetty.JettyServerHelper;
import org.restlet.service.ConnectorService;

import edu.am.bigdata.controller.resources.LoadChecker;

/**
 * @author devan
 * @date 02-May-2014
 * @mail devanms@am.amrita.edu
 * 
 * @note API Server listen to client requests.
 */

public class APIServer {
	private static Logger log = Logger.getLogger(APIServer.class.getName());

	/**
	 * @param args
	 */

	public APIServer() {

	}

	public static void main(String[] args) {

		try {
			Component component = new Component();
			Server server = new Server(Protocol.HTTP, 8188);

			component.getServers().add(server);
			JettyServerHelper jettyHelper = new org.restlet.ext.jetty.HttpServerHelper(
					server);
			@SuppressWarnings("static-access")
			ConnectorService a = jettyHelper.getConnectorService();
			a.start(); // Start Rest server
			server.getContext().getParameters().add("maxThreads", "10000");
			server.getContext().getParameters().add("persistingConnections", "false");

			
			component.getDefaultHost().attach("/getStatus", LoadChecker.class);

			component.start();

			log.info("*********SERVER STARTED @ PORT 8188*************");
		} catch (Exception e) {
			log.debug("Exception while REST API Routing and Server start", e);

		}
	}

}
