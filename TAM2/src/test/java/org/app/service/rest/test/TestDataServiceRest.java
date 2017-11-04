package org.app.service.rest.test;

import java.util.logging.Logger;

import javax.ws.rs.core.Response;

//import org.jboss.resteasy.client.jaxrs.ResteasyClient;
//import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
//import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.junit.BeforeClass;
import org.junit.Test;
//
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class TestDataServiceRest {
	private static Logger logger = Logger.getLogger(TestDataServiceRest.class.getName());
	private static String serviceURL = "http://localhost:8080/TAM2/rest/service";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}	

	@Test
	public void test() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(serviceURL);
        Response response = target.request().get();
        String value = response.readEntity(String.class);
        response.close(); 
        
        System.out.println("REST Response >>>>>>>>> " + value);
	}

}
// https://github.com/wildfly/quickstart/tree/10.x/helloworld-rs