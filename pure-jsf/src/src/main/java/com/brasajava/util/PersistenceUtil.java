package com.brasajava.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = createEntityManagerFactory();

	private static EntityManagerFactory createEntityManagerFactory() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("purejsf");
		return emf;
	}
	public static EntityManagerFactory getEntityManagerFactory(){
		return ENTITY_MANAGER_FACTORY;
	}

}
