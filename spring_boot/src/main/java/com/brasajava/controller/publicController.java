package com.brasajava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class publicController {
	
	@RequestMapping("/home")
	public String home(){
		return "home";
	}
	

}
