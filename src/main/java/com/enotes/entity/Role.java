package com.enotes.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor  @AllArgsConstructor 
@Table(name="roles")
public class Role {
	
	private int roleId;
	
	@Column(length=20,unique=true)
	private String desc;
	
	private String roleName ;
	
	
	
	@ManyToMany(fetch=FetchType.EAGER)
	
	
	private List<User> users;

}
