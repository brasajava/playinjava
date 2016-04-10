package com.brasajava.spring.managedbeans;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.brasajava.beans.User;

@Component
@Scope("request")
public class UserManagedBean extends User{
	@PostConstruct
	public void init(){
		this.setName("Ricardo");
	}

}
