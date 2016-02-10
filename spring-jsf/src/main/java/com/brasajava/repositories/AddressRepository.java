package com.brasajava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brasajava.beans.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
