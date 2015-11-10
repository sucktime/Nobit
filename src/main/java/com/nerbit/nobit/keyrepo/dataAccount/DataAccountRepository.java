package com.nerbit.nobit.keyrepo.dataAccount;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nerbit.nobit.keyrepo.user.User;

@Transactional
public interface DataAccountRepository  extends CrudRepository<DataAccount, Long>{
	
	List<DataAccount> findByUser(User user);
	
	DataAccount save(DataAccount dataAccount);
	
	@Modifying
	@Query(value="delete from DataAccount ac where ac.id=?1")
	void deleteOne(long id);
	
}
