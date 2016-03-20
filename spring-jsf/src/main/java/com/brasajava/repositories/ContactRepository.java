package com.brasajava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brasajava.beans.ContactManagerImpl;

public interface ContactRepository extends JpaRepository<ContactManagerImpl, Long>{

}
