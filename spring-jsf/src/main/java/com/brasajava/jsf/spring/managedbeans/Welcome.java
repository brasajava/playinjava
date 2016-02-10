package com.brasajava.jsf.spring.managedbeans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import com.brasajava.beans.User;
import com.brasajava.services.JpaService;

@ManagedBean
@RequestScoped
public class Welcome {
	private String hello = "Welcome to my hello world";
	private long id;
	private String name;
	private String lastname;
	private int level;

	@Autowired
	@Qualifier("user")
	private User person;
	@Autowired
	@Qualifier("userServiceImpl")
	private JpaService<User> service;

	@Transactional
	public String add() {
		person.setLevel(this.level);
		person.setId(this.id);
		person.setLastname(this.lastname);
		person.setName(this.name);
		this.person = service.save(this.person);
		this.level = person.getLevel();
		this.id = person.getId();
		this.lastname = person.getLastname();
		this.name = person.getName();
		for(User p: service.findAll()){
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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public User getPerson() {
		return person;
	}

	public void setPerson(User person) {
		this.person = person;
	}

}
