package com.brasajava.managedbean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.brasajava.beans.User;
import com.brasajava.repositories.UserRepository;

@ManagedBean
@RequestScoped
public class Welcome {

	private String hello = "Hello JSF";
	
	@PostConstruct
	public void init(){
		System.out.println("Init Method");
		UserRepository repository = new UserRepository();
		for(User u : repository.findAll()){
			System.out.println(u.getName());
		}
	}
	@PreDestroy
	public void destroy(){
		System.out.println("Destroy Method");
	}

	public String getHello() {
		return hello;
	}

	public void setHello(String hello) {
		this.hello = hello;
	}
	
	
}
