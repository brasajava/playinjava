package com.brasajava.spring.managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.brasajava.beans.Address;
import com.brasajava.beans.Contact;
import com.brasajava.beans.User;
import com.brasajava.services.JpaService;


@Controller
@Scope("session")
public class UserManagedBeanController {
	@Autowired
	private JpaService<User> userService;
	@Autowired
	private JpaService<Address> addressService;
	@Autowired
	private JpaService<Contact> contactService;
	@Autowired
	private UserManagedBean userManagedBean;
	private List<User> userList;
	private List<Address> addressList;
	private List<Contact> contactList;
	
	
	
	public UserManagedBean getUserManagedBean(){
		return userManagedBean;
	}
	
	/*Status*/
	public UserManagedBeanController(){
		System.out.println("UserManagedBeanController Constructor");
	}
	@PostConstruct
	public void init(){
		System.out.println("UserManagedBeanController Init");
		refreshList();
	}
	private void refreshList(){
		userList = userService.findAll();
		addressList = addressService.findAll();
		contactList = contactService.findAll();
	}
	@PreDestroy
	public void destroy(){
		System.out.println("UserManagedBeanController Destroy");
	}

	/*Status*/
	
	/*Services*/
	public JpaService<User> getUserService() {
		return userService;
	}

	public void setUserService(JpaService<User> userService) {
		this.userService = userService;
	}

	public JpaService<Address> getAddressService() {
		return addressService;
	}

	public void setAddressService(JpaService<Address> addressService) {
		this.addressService = addressService;
	}

	public JpaService<Contact> getContactService() {
		return contactService;
	}

	public void setContactService(JpaService<Contact> contactService) {
		this.contactService = contactService;
	}
	/*Services*/
	
	
	/*Begin List Getters and Setters*/
	public List<User> getUserList() {	
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}
	/*End List Getters and Setters*/
	
	public void save(){
		System.out.println("Save");
		User user = userManagedBean.getUser();
		user = userService.saveAndFlush(user);
		userManagedBean.setUser(user);
		user = null;
		refreshList();
	}
}
