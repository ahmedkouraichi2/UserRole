package com.enotes;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.enotes.Services.UserServices;
import com.enotes.entity.Role;
import com.enotes.entity.User;

@SpringBootApplication
@EnableJpaAuditing
public class SbtEnotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbtEnotesApplication.class, args);
	}
	
	@Bean
	
	CommandLineRunner start(UserServices userServices) {
		return args ->{
			 User u = new User();
			 u.setUsername("user1");
			 u.setPassword("123456");
			 userServices.addUser(u);
			 
			 
			 
			 
			 User u2 = new User();
			 u.setUsername("user1");
			 u.setPassword("123456");
			 userServices.addUser(u2);
			 
			 
			 User u3 = new User();
			 u.setUsername("admin");
			 u.setPassword("123456");
			 userServices.addUser(u3);
			 
			 
			 
	 Stream.of("STUDENT","USER","ADMIN").forEach(r ->{
		 Role role1 = new Role();
		 role1.setRoleName(r);
		 userServices.addRole(role1);
		 
	 });
			 
	 
	 userServices.addRoleToUser("user1", "STUDENT");
	 userServices.addRoleToUser("user1", "ADMIN");
	 userServices.addRoleToUser("user2","STUDENT");
	 
	 userServices.addRoleToUser("admin","ADMIN");
	 userServices.addRoleToUser("admin","USER");
			 
			 
		};
		
		
		
	
		 
		

	}

}
