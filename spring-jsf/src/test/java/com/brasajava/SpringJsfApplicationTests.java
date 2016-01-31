package com.brasajava;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.brasajava.beans.User;
import com.brasajava.services.PersonService;

//import scala.annotation.meta.setter;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringJsfApplication.class)
@WebAppConfiguration
public class SpringJsfApplicationTests {

	@Autowired
	private PersonService service;
	@Test
	public void contextLoads() {
		User person = new User();
		person.setLevel(5);
		person.setLastname("Gonçalves de Moraes");
		person.setName("Ricardo Maximino");
		
		service.save(person);
		
		for(User p : service.getList()){
			System.out.println(p.getId() + " " + p.getName() + " "+ p.getLastname() + " " + person.getLevel());
		}
	}

}
