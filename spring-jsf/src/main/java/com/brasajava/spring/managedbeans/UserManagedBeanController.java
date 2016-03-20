package com.brasajava.spring.managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.brasajava.beans.AddressImpl;
import com.brasajava.beans.ContactManagerImpl;
import com.brasajava.beans.User;
import com.brasajava.services.JpaService;


@Controller
@Scope("session")
public class UserManagedBeanController {
	@Autowired
	private JpaService<User> userService;
	@Autowired
	private JpaService<AddressImpl> addressService;
	@Autowired
	private JpaService<ContactManagerImpl> contactService;
	@Autowired
	private UserManagedBean userManagedBean;
	private List<User> userList;
	private List<AddressImpl> addressList;
	private List<ContactManagerImpl> contactList;
	
	
	
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

	public JpaService<AddressImpl> getAddressService() {
		return addressService;
	}

	public void setAddressService(JpaService<AddressImpl> addressService) {
		this.addressService = addressService;
	}

	public JpaService<ContactManagerImpl> getContactService() {
		return contactService;
	}

	public void setContactService(JpaService<ContactManagerImpl> contactService) {
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

	public List<AddressImpl> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<AddressImpl> addressList) {
		this.addressList = addressList;
	}

	public List<ContactManagerImpl> getContactList() {
		return contactList;
	}

	public void setContactList(List<ContactManagerImpl> contactList) {
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
