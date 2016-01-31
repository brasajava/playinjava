package com.brasajava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brasajava.beans.User;
import com.brasajava.repositories.UserRepository;

@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	private UserRepository repository;

	@Override
	public User save(User person) {
		return repository.save(person);
	}

	@Override
	public void delete(User person) {
		repository.delete(person);
	}

	@Override
	public void edit(User person) {
		repository.save(person);
	}

	@Override
	public User getPerson(Long id) {
		return repository.findOne(id);
	}

	@Override
	public void setRepository(UserRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<User> getList(){
		return repository.findAll();
	}
}
