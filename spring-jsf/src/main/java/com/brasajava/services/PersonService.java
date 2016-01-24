package com.brasajava.services;

import java.util.List;

import com.brasajava.beans.Person;
import com.brasajava.repositories.PersonRepository;

public interface PersonService{
	
	void setRepository(PersonRepository repository);
	Person save(Person person);
	void delete(Person person);
	void edit(Person person);
	Person getPerson(Long id);
	List<Person> getList();
}
