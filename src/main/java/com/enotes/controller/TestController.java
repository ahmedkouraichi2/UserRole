package com.enotes.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class TestController {
	
	@GetMapping("/")
	
	public String  helloUser() {
		 return "Haloo User";
		 
	}

}
