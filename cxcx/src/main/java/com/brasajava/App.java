package com.brasajava;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.brasajava.beans.User;

public class App {

	//private static Logger log = Logger.getGlobal();

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        @SuppressWarnings("unchecked")
		List<User> users = entityManager.createQuery("Select user From User as user").getResultList();
        System.out.println(users.size());
        for(User found : users){
        System.out.println(found.getId() + " " + found.getName());
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        users = null;
        entityManagerFactory.close();
              // log.info("found=" + found);
    }
    public List<User> getList(EntityManager em){
    	@SuppressWarnings("unchecked")
		List<User> users = em.createQuery("Select user From User as user").getResultList();
    	return users;
    }


}
