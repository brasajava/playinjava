package com.brasajava.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublicController {
	
	@RequestMapping("/home")
	public String home(Map<String,Object> map){
		map.put("name", "Ricardo Maximino");
		return "index";
	}

}
