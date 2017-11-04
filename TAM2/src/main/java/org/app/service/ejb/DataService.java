package org.app.service.ejb;

import javax.ejb.Remote;

import org.app.patterns.EntityRepository;
import org.app.service.entities.EntityBase;


@Remote
public interface DataService extends EntityRepository<EntityBase>{

	String sayRest();

}