package org.app.service.rest.test;

import java.util.logging.Logger;

import javax.ws.rs.core.Response;

import org.app.patterns.EntityRepository;
import org.app.service.ejb.DataService;
import org.app.service.entities.EntityBase;
import org.app.service.rest.ApplicationConfig;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
//import org.jboss.resteasy.client.jaxrs.ResteasyClient;
//import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
//import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

//
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RunWith(Arquillian.class)
public class TestDataServiceRestArq {
	private static Logger logger = Logger.getLogger(TestDataServiceRestArq.class.getName());
	private static String serviceURL = "http://localhost:8080/msd-test/rest/service";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}	

	@Deployment
	public static Archive<?> createDeployment() {
	        return ShrinkWrap
	                .create(WebArchive.class, "msd-test.war")
	                .addPackage(EntityRepository.class.getPackage())
	                .addPackage(DataService.class.getPackage())
	                .addPackage(EntityBase.class.getPackage())
	                .addPackage(ApplicationConfig.class.getPackage())
	                .addAsResource("META-INF/persistence.xml")
	                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}	
	
	@Test
	public void test() {
		logger.info(">>>> TEST REST Clienti with Arquilian ::  " + serviceURL);
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(serviceURL);
        Response response = target.request().get();
        String value = response.readEntity(String.class);
        response.close(); 
        
        System.out.println(">>>> >>>> REST Response >>>> >>>>> " + value);
	}

}
// https://github.com/wildfly/quickstart/tree/10.x/helloworld-rs