package com.brasajava.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PublicController {

	@RequestMapping("/spring/*")
	@ResponseBody
	public String creator(){
		return "Ricardo Maximino Gonçalves de Moraes";
	}
}
