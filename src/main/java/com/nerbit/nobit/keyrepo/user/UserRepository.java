package com.nerbit.nobit.keyrepo.user;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByUserId(String userId);
}
