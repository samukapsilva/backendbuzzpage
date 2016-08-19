package br.com.buzzpage.jetty;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.xml.XmlConfiguration;

import br.com.buzzpage.exception.BuzzPageErrorHelper;

public class JettyServer {
	private static Logger LOGGER = Logger.getLogger(JettyServer.class);

	private Server server;

	public static void main(String[] args) {
		Properties errors = new Properties();
		try {
			errors.load(ClassLoader.getSystemResourceAsStream("errors.properties"));
			JettyServer jettyServer = new JettyServer(8082);
			jettyServer.run();
		} catch (Exception e) {
			String translatedErrorMessage = BuzzPageErrorHelper.translateErrorMessage(errors, e);
			LOGGER.error(translatedErrorMessage);
			e.printStackTrace();
		}
	}

	public JettyServer(Integer port) throws Exception {
		System.setProperty("jndi.name", "java:/restBuzzPageDB");

		Resource fileserver_xml = Resource.newSystemResource("config/jetty-embedded.xml");
		XmlConfiguration configuration = new XmlConfiguration(fileserver_xml.getInputStream());

		server = new Server(port == null ? 8080 : port);

		WebAppContext webapp = (WebAppContext) configuration.configure();
		webapp.setContextPath("/backendjetty");
		webapp.setResourceBase("src/main/webapp");
		server.setHandler(webapp);
	}

	public void run() throws Exception {
		server.start();
		server.join();
	}

	public void start() throws Exception {
		server.start();
	}

	public void stop() throws Exception {
		server.stop();
	}

}
