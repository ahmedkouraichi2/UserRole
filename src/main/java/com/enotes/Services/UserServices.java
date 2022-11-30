package com.enotes.Services;

import com.enotes.entity.Role;
import com.enotes.entity.User;

public interface UserServices {
	User addUser(User user);
	Role addRole (Role role);
	User finUserByUserName(String userName);
	Role findRoleByRoleName(String roleName);
	void addRoleToUser(String username, String roleName );
	User authentificate(String userName ,String password);
	
	

}
