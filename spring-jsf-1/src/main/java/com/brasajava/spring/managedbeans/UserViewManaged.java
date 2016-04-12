package com.brasajava.spring.managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.primefaces.event.SelectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.brasajava.beans.AddressImpl;
import com.brasajava.beans.User;
import com.brasajava.beans.interfaces.Address;
import com.brasajava.repositories.UserRepository;

@Component
@Scope("request")
public class UserViewManaged {
	private static final Logger log = LoggerFactory.getLogger(UserViewManaged.class);
	
	@Autowired private UserRepository userRepository;
	@Autowired private User user;
	@Autowired private Address address;
	private String search;
	private List<User> users;
	
	
	@PostConstruct
	public void init(){
		this.refreshUsers();
		log.info("UserViewManaged starts.");
		System.out.println("User name = " + user.getName());
		System.out.println("Country = " + address.getCountry());
		System.out.println("Repository = " +  userRepository);
	}
	@PreDestroy
	public void destroy(){
		log.info("UserViewManaged ends.");
	}
	
	public void save(){
		log.info("Save Method start");
		this.setToSave();
		try{
		userRepository.save(user);
		log.info("The user has been saved successfully");
		}catch(Exception ex){
			log.error("Constrain Violation");
		}
	}
	
	private void setToSave(){
		log.info("setToSave Method userName = " + user.getName() +" country = "+ address.getCountry());
		try{
		User newUser = new User();
		Address newAddress = new AddressImpl();
		
		newUser.setId(user.getId());
		newUser.setName(user.getName());
		newUser.setFirstLastName(user.getFirstLastName());
		newUser.setSecondLastName(user.getSecondLastName());
		newUser.setBirthday(user.getBirthday());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());
		newUser.setActive(user.isActive());
		newUser.setEmails(user.getEmails());
		newUser.setPhones(user.getPhones());
		newUser.setCredit(user.getCredit());
		
		newAddress.setId(address.getId());
		newAddress.setCountry(address.getCountry());
		newAddress.setState(address.getState());
		newAddress.setCity(address.getCity());
		newAddress.setTown(address.getTown());
		newAddress.setStreet(address.getStreet());
		newAddress.setNumber(address.getNumber());
		
		user = newUser;
		address = newAddress;
		user.setAddress(address);
		log.info("The setting to Save has been applided successfully");
		}catch(Exception ex){
			log.error("Set to save erro is: " + ex.toString());
		}
	}
	public void onRowSelect(SelectEvent event) {
		user = userRepository.findOne(((User)event.getObject()).getId());
	}
	private void refreshUsers(){
		users = (List<User>) userRepository.findAll();
	}
	public void findByName(){
		users = userRepository.findByName(search);
	}
	public void findByFirstLastName(){
		users = userRepository.findByFirstLastName(search);
	}
	public void findBySecondLastName(){
		users = userRepository.findBySecondLastName(search);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}