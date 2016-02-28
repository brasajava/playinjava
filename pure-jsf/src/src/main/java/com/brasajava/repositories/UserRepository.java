package com.brasajava.repositories;

import java.util.List;

import javax.persistence.EntityManager;

import com.brasajava.beans.User;
import com.brasajava.util.PersistenceUtil;

public class UserRepository implements JpaRepository<User>{
	
	private EntityManager getEntityManager(){
		return PersistenceUtil.getEntityManagerFactory().createEntityManager();
	}

	@Override
	public User save(User user) {
		EntityManager em = this.getEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.flush();
		em.refresh(user);
		em.getTransaction().commit();
		return user;
	}

	@Override
	public User getOne(long id) {
		EntityManager em = this.getEntityManager();
		em.getTransaction().begin();
		User user = em.find(User.class, new Long(id));
		em.getTransaction().commit();
		return user;
	}

	@Override
	public List<User> findAll() {
		EntityManager em = this.getEntityManager();
		em.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<User> users = em.createQuery("Select user From User as user").getResultList();
		em.getTransaction().commit();
		return users;
	}

}
