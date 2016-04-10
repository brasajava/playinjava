package com.brasajava.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.brasajava.SpringJsf1Application;
import com.brasajava.beans.AddressImpl;
import com.brasajava.beans.Email;
import com.brasajava.beans.Permission;
import com.brasajava.beans.Phone;
import com.brasajava.beans.interfaces.Address;
import com.brasajava.repositories.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringJsf1Application.class)
@WebAppConfiguration
public class TestUser {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void contextLoads() {
	}

	private List<Phone> phoneList(){
		String[] description = {"home","mobile","job",};
		String[] contacts = {"966230267","634753562","966552211"};
		Phone phone = new Phone();
		List<Phone> list = new ArrayList<Phone>();
		for(int i = 0; i < contacts.length; i++){
			phone.setContact(contacts[i]);
			phone.setDescription(description[i]);
			phone.setMain(false);
			list.add(phone);
		}
		int random = (int) Math.round(Math.random()*contacts.length);
		list.get(random).setMain(true);
		return list;
	}
	private List<Email> emailList(){
		String[] description = {"home","whatsapp","job",};
		String[] contacts = {"ricardomaximino@hotmail.com","ricardomaximino@gmail.com","ricardomaximino@yahoo.com.br"};
		Email email = new Email();
		List<Email> list = new ArrayList<Email>();
		for(int i = 0; i < contacts.length; i++){
			email.setContact(contacts[i]);
			email.setDescription(description[i]);
			email.setMain(false);
			list.add(email);
		}
		int random = (int) Math.round(Math.random()*contacts.length);
		list.get(random).setMain(true);
		return list;
	}
	private List<Permission> permissionList(){
		List
		return null;
	}
	private Address generateAddress(){
		Address address = new AddressImpl();
		address.setCountry("España");
		address.setState("Valencia");
		address.setCity("Alicante");
		address.setTown("Santa Pola");
		address.setStreet("Calle Ganaderos");
		address.setNumber("24");
		return address;
	}
}
