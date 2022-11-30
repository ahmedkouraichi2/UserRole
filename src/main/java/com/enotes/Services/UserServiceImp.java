package com.enotes.Services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enotes.entity.Role;
import com.enotes.entity.User;
import com.enotes.repository.RoleRepository;
import com.enotes.repository.UserRepository;

import lombok.AllArgsConstructor;


@Service
@Transactional 

@AllArgsConstructor 
public class UserServiceImp implements  UserServices{
	

	private UserRepository userRepository;
	

	private RoleRepository roleRepository ;

	@Override
	public User addUser(User user) {
		
		user.setUserId(UUID.randomUUID().toString());
		return  userRepository.save(user);
	}

	@Override
	public Role addRole(Role role) {
		 return roleRepository.save(role);
	}

	@Override
	public User finUserByUserName(String userName) {
       return userRepository.findByUsername(userName);
	}

	@Override
	public Role findRoleByRoleName(String roleName) {
		// TODO Auto-generated method stub
		return roleRepository.findByRoleName(roleName);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		User user = finUserByUserName(username);
		Role role = findRoleByRoleName(roleName);
		 if(user.getRoles() !=null) {
			  user.getRoles().add(role);
			  userRepository.save(user);
		 }
		
		
	}

	@Override
	public User authentificate(String userName, String password) {
	   User user = userRepository.findByUsername(userName);
	   if(user ==null)throw new RuntimeException("Bad credential");
	   
	   if(user.getPassword().equals(password)) {
	    	 return user;
	     }
	  
	   
	
	     		throw new RuntimeException("Bad credential");
	
	}}
