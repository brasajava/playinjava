package com.brasajava.spring.managedbeans;

import java.time.LocalDate;
import java.util.HashSet;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.brasajava.beans.AddressImpl;
import com.brasajava.beans.ContactManagerImpl;
import com.brasajava.beans.Email;
import com.brasajava.beans.Phone;
import com.brasajava.beans.User;

@Component
@Scope("session")
public class UserManagedBean extends User {

	private static final long serialVersionUID = 2335022646838275957L;
	private Email email;
	private Phone phone;
	private long id;
	
	/*Constructor*/
	public UserManagedBean(){
		System.out.println("UserManagedBean Contruct");
		this.setAddress(new AddressImpl());
		this.setContactManager(new ContactManagerImpl());
	}
	public void setUser(User user){
		this.setActive(user.getActive());
		this.setAddress(user.getAddress());
		this.setBalance(user.getBalance());
		this.setBirthday(user.getBirthday());
		this.setContactManager(user.getContactManager());
		this.setDocNumber(user.getDocNumber());
		this.setDocType(user.getDocType());
		this.setId(user.getId());
		this.setLastname(user.getLastname());
		this.setLevel(user.getLevel());
		this.setLoginName(user.getLoginName());
		this.setName(user.getName());
		this.setPassword(user.getPassword());
		this.setStartDate(user.getStartDate());
	}
	@Override
	public void setId(long id){
		System.out.println(" SetId = " + id);
		this.id = id;
	}
	@Override
	public long getId(){
		System.out.println(" GetId = " + id);
		return id;
	}
	public User getUser(){
		System.out.println("GetUser");
		User user = new User();
		if(this.getId()> 0){
			user.setActive(this.getActive());
			user.setLevel(this.getLevel());
			user.setStartDate(this.getStartDate());
		}else{
			user.setActive(false);
			user.setStartDate(LocalDate.now());
		}
		user.setAddress(this.getAddress());
		user.setBalance(this.getBalance());
		
		if(this.getBirthday() != null)user.setBirthday(this.getBirthday());
		
		user.setContactManager(this.getContactManager());
		user.setDocNumber(this.getDocNumber());
		user.setDocType(this.getDocType());
		user.setId(this.getId());
		user.setLastname(this.getLastname());

		user.setLoginName(this.getLoginName());
		user.setName(this.getName());
		user.setPassword(this.getPassword());
		if(this.getContactManager().getEmails().size()<=0){
			email = new Email();
			email.setDescription("Principal");
			email.setContact(this.getLoginName());
			this.getContactManager().getEmails().add(email);
		}else{
			email = this.getContactManager().getEmails().iterator().next();
			email.setContact(this.getLoginName());
		}
		System.out.println(user.getId() + " " + user.getName());
		return user;
	}
	public void cleanUp(){
		cleanUser();
		cleanAddress();
		cleanContact();
	}
	private void cleanUser(){
		this.setActive(false);
		this.setBalance(null);
		this.setBirthday(null);
		this.setDocNumber("");
		this.setDocType("");
		this.setId(0);
		this.setLastname("");
		this.setLevel(0);
		this.setLoginName("");
		this.setName("");
		this.setPassword("");
		this.setStartDate(null);
	}
	private void cleanAddress(){
		this.setAddress(new AddressImpl());
	}
	private void cleanContact(){
		if(this.getContactManager().getEmails().size()> 0)this.getContactManager().setEmails(new HashSet<Email>());
		if(this.getContactManager().getPhones().size()> 0)this.getContactManager().setPhones(new HashSet<Phone>());
	}
	
	public void setStringBirthday(String birthday) {
		if (birthday.length() >= 5) {
			String[] dataValues = birthday.split("/");
			this.setBirthday(LocalDate.of(Integer.parseInt(dataValues[2]), Integer.parseInt(dataValues[1]),
					Integer.parseInt(dataValues[0])));
		}else{
			//throw new IllegalArgumentException("The data Format should be in dd/MM/YYYY format");
		}
	}
	public String getStringBirthday(){
		return  (getBirthday()!=null)?this.getBirthday().getDayOfMonth()+"/"+this.getBirthday().getMonthValue()+"/" + this.getBirthday().getYear() : null;
	}
	public String getTelephoneNumber() {
		if(this.getContactManager().getPhones().size()>0){
			phone = this.getContactManager().getPhones().iterator().next();
		}else{
			phone = new Phone();
		}
		return phone.getContact();
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.phone.setContact(telephoneNumber);
		this.phone.setDescription("Principal");
		this.getContactManager().getPhones().add(phone);
	}

}
