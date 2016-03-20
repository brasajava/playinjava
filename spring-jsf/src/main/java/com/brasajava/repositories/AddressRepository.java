package com.brasajava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brasajava.beans.AddressImpl;

public interface AddressRepository extends JpaRepository<AddressImpl, Long>{

}
