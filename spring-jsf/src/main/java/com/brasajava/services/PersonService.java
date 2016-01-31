package com.brasajava.services;

import java.util.List;

import com.brasajava.beans.User;
import com.brasajava.repositories.UserRepository;

public interface PersonService{
	
	void setRepository(UserRepository repository);
	User save(User person);
	void delete(User person);
	void edit(User person);
	User getPerson(Long id);
	List<User> getList();
}
