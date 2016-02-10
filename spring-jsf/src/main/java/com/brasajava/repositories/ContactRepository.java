package com.brasajava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brasajava.beans.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

}
