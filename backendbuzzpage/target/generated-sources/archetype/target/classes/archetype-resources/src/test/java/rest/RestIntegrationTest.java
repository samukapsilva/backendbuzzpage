#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import ${package}.jetty.JettyServer;

public abstract class RestIntegrationTest {
	protected WebTarget target;
	protected Client client;
	private JettyServer jettyServer;

	@Before
	public void setUp() throws Exception {
		jettyServer = new JettyServer(8081);
		jettyServer.start();

		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(JacksonFeature.class);

		client = ClientBuilder.newClient(clientConfig);
	}

	@After
	public void tearDown() throws Exception {
		jettyServer.stop();
	}

	public Response executeJsonGet(String uri) {
		target = client.target(uri);

		Builder request = target.request();
		request.header("Content-type", MediaType.APPLICATION_JSON);

		Response response = request.get();
		Assert.assertTrue(response.getStatus() == 200);

		return response;
	}

}
