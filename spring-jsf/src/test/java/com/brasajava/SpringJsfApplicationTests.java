package com.brasajava;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.brasajava.beans.Address;
import com.brasajava.beans.AddressImpl;
import com.brasajava.beans.ContactManagerImpl;
import com.brasajava.beans.Email;
import com.brasajava.beans.Phone;
import com.brasajava.beans.User;
import com.brasajava.services.JpaService;

//import scala.annotation.meta.setter;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringJsfApplication.class)
@WebAppConfiguration
public class SpringJsfApplicationTests {

	@Autowired
	@Qualifier("userServiceImpl")
	private JpaService<User> service;
	@Autowired
	@Qualifier("addressServiceImpl")
	private JpaService<AddressImpl> addressService;
	@Autowired
	@Qualifier("contactServiceImpl")
	private JpaService<ContactManagerImpl> contactService;
	@Test
	public void contextLoads() {
		User user = new User();
		user.setLevel(5);
		user.setLastname("Gonçalves de Moraes");
		user.setName("Ricardo Maximino");
		user.setActive(true);
		user.setBalance(new BigDecimal(500));
		user.setBirthday(LocalDate.of(1982, 11, 15));
		user.setDocNumber("Y1580371D");
		user.setDocType("NIE");
		user.setLoginName("ricardomaximino@hotmail.com");
		user.setPassword("Ricardo2");
		user.setStartDate(LocalDate.now());
		
		AddressImpl address = new AddressImpl();
		address.setCountry("España");
		address.setState("Valencia");
		address.setCity("Alicante");
		address.setTown("Santa Pola");
		address.setNeighborhood("Centro");
		address.setNumber("24");
		address.setNote("Adoro minha casa");
		
		Email gmail = new Email();
		gmail.setDescription("GMail");
		gmail.setContact("ricardomaximino@gmail.com");
		
		Email hotmail = new Email();
		hotmail.setDescription("HotMail");
		hotmail.setContact("ricardomaximino@hotmail.com");
		
		Phone homePhone = new Phone();
		homePhone.setDescription("Home");
		homePhone.setContact("966230267");
		
		Phone mobile = new Phone();
		mobile.setDescription("Mobile");
		mobile.setContact("634753562");
		
		ContactManagerImpl contact = new ContactManagerImpl();
		contact.getEmails().add(gmail);
		contact.getEmails().add(hotmail);
		contact.getPhones().add(homePhone);
		contact.getPhones().add(mobile);
		
		user.setAddress(address);
		user.setContactManager(contact);
		//addressService.save(address);
		//contactService.save(contact);
		addressService.saveAndFlush(address);
		contactService.saveAndFlush(contact);
		service.saveAndFlush(user);
		
		for(User u : service.findAll()){
			System.out.println(u);
		}
		for(Address a : addressService.findAll()){
			System.out.println(a.getCity());
		}
	}

}
