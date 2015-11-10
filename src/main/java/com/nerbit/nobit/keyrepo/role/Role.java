package com.nerbit.nobit.keyrepo.role;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class Role {
	
	public static final int ROLE_ROOT = 1;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	
	@NotNull
	@Column
	
	int role; 
	
	String hexKey;
}
