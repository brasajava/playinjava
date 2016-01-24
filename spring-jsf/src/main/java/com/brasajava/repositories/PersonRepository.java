package com.brasajava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brasajava.beans.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
