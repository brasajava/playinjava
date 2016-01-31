package com.brasajava.jsf.spring.managedbeans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.brasajava.beans.User;
import com.brasajava.services.PersonService;

@Component
@Scope("view")
public class Welcome {
	private String hello = "Welcome to my hello world";
	private long id;
	private String name;
	private String lastname;
	private int age;

	@Autowired
	private User person;
	@Autowired
	private PersonService service;

	@Transactional
	public String add() {
		person.setLevel(this.age);
		person.setId(this.id);
		person.setLastname(this.lastname);
		person.setName(this.name);
		this.person = service.save(this.person);
		this.age = person.getLevel();
		this.id = person.getId();
		this.lastname = person.getLastname();
		this.name = person.getName();
		for(User p: service.getList()){
			System.out.println(p.getName());
		}
		return "myResponse";
	}

	public Welcome() {
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
	public void init() {
		System.out.println("Welcome init");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Welcome predestroy");
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public User getPerson() {
		return person;
	}

	public void setPerson(User person) {
		this.person = person;
	}

}
