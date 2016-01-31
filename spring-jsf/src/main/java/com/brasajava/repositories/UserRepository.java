package com.brasajava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brasajava.beans.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
