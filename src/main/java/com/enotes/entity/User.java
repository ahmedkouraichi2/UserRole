package com.enotes.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor  @AllArgsConstructor 

@Table(name="user")
public class User {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String userId;
	
	@Column(name="USER_NAME",unique=true,length= 20)
	private String username;
	private String password ;
	
	
	@JsonProperty (access =JsonProperty.Access.WRITE_ONLY)
	@ManyToMany(mappedBy="users",fetch = FetchType.EAGER)
	private List<Role> roles  = new ArrayList<>();
	
	

}
