package com.brasajava.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class Welcome {
	private String hello = "Welcome to my hello world";
	private String name;
	private String lastname;
	
	
	public Welcome(){
		System.out.println(hello);
	}

	public String getHello() {
		return hello;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setHello(String hello) {
		this.hello = hello;
	}
	@PostConstruct
	public void init(){
		System.out.println("Welcome init");
	}

	@PreDestroy
	public void destroy(){
		System.out.println("Welcome predestroy");
	}

}
