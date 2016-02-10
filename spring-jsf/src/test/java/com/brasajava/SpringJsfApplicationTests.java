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
import com.brasajava.beans.Contact;
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
	private JpaService<Address> addressService;
	@Autowired
	@Qualifier("contactServiceImpl")
	private JpaService<Contact> contactService;
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
		
		Address address = new Address();
		address.setCountry("España");
		address.setState("Valencia");
		address.setCity("Alicante");
		address.setTown("Santa Pola");
		address.setNeighborhood("Centro");
		address.setNumber("24");
		address.setNote("Adoro minha casa");
		
		Email gmail = new Email();
		gmail.setDescription("GMail");
		gmail.setEmail("ricardomaximino@gmail.com");
		
		Email hotmail = new Email();
		hotmail.setDescription("HotMail");
		hotmail.setEmail("ricardomaximino@hotmail.com");
		
		Phone homePhone = new Phone();
		homePhone.setDescription("Home");
		homePhone.setPhone("966230267");
		
		Phone mobile = new Phone();
		mobile.setDescription("Mobile");
		mobile.setPhone("634753562");
		
		Contact contact = new Contact();
		contact.getEmails().add(gmail);
		contact.getEmails().add(hotmail);
		contact.getPhones().add(homePhone);
		contact.getPhones().add(mobile);
		
		user.setAddress(address);
		user.setContact(contact);
		addressService.saveAndFlush(address);
		contactService.saveAndFlush(contact);
		service.save(user);
		
		for(User u : service.findAll()){
			System.out.println(u);
		}
	}

}
