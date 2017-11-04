package org.app.service.ejb.test;

import java.util.logging.Logger;

import javax.ejb.EJB;

import org.app.patterns.EntityRepository;
import org.app.service.ejb.DataService;
import org.app.service.ejb.DataServiceEJB;
import org.app.service.entities.EntityBase;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class TestDataServiceEJBArq {
	private static Logger logger = Logger.getLogger(TestDataServiceEJBArq.class.getName());
	
	// Arquilian infrastructure
	@EJB
	private static DataService service;
	
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
	                .addAsResource("META-INF/persistence.xml")
	                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	   }
	
	@Test
	public void test() {
		logger.info("DEBUG: Junit TESTING ...");
		String response = service.sayRest();
		assertNotNull("Data Service failed!", response);
		logger.info("DEBUG: EJB Response ..." + response);
	}

}
