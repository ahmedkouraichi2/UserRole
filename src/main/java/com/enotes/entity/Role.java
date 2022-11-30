package com.enotes.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;



@Entity
@Table(name="roles")
public class Role {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleId;
	

	private String desc;
	
	private String roleName ;
	
	
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="USER_ROLE")
	
	@JsonProperty (access =JsonProperty.Access.WRITE_ONLY)
	private List<User> users = new ArrayList<>();

	
	
	//getter & Setter
	
	public int getRoleId() {
		return roleId;
	}



	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}



	public String getDesc() {  
		return desc;
	}



	public void setDesc(String desc) {
		this.desc = desc;
	}



	public String getRoleName() {
		return roleName;
	}



	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}



	public List<User> getUsers() {
		return users;
	}



	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	public Role(){
		
	}



	public Role(int roleId, String desc, String roleName, List<User> users) {
	
		this.roleId = roleId;
		this.desc = desc;
		this.roleName = roleName;
		this.users = users;
	}
	
	
	
	
	
	
	

}
