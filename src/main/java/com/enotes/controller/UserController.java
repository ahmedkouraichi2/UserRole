package com.enotes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.enotes.Services.UserServiceImp;
import com.enotes.entity.User;

@RestController
public class UserController {
	
	@Autowired 
 private UserServiceImp userService;
	
	@GetMapping("/users/{username}")
public User user(@PathVariable String  username) {
		 User user = userService.finUserByUserName(username);
		 return user ;

	}
	
	
	
	
	
	

}
