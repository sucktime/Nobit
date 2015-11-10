package com.nerbit.nobit.keyrepo.role;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="root_role")
public class RootRole extends Role{
	{
		role = Role.ROLE_ROOT;
	}
	
	
}
