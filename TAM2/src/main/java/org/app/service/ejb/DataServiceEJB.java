package org.app.service.ejb;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.app.patterns.EntityRepository;
import org.app.patterns.EntityRepositoryBase;
import org.app.service.entities.EntityBase;

/**
 * Session Bean implementation class ScrumTeamRepositoryService
 * Aggregate Repository Service Facade: Project - features - releases
 */
@Path("/service") // http://localhost:8080/SAM1/rest/service
// 1. Remote interface
@Stateless
@LocalBean
public class DataServiceEJB extends EntityRepositoryBase<EntityBase> implements DataService{
	private static Logger logger = Logger.getLogger(DataServiceEJB.class.getName());
	
	// 2. Inject resource 
//	@PersistenceContext(unitName="MSD")
//	private EntityManager em;

    // 3. Init with injected EntityManager
	private EntityRepository<EntityBase> entityRepository;
	
    @PostConstruct
	public void init(){
		logger.info("Initialized :");		
	}	

	public DataServiceEJB() {
		super();
		logger.info("INIT DEF CONSTRUCTOR : " + this.em);		
	}

	
	/********************************************************************/
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayRest() {
		return "Resting ... happily on Wildfly 10! ";
	}	
	/********************************************************************/
}
