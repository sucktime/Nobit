package com.nerbit.nobit.keyrepo.dataKey;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface DataKeyRepository extends CrudRepository<DataKey, Long> {
	
	public DataKey findOne(Long keyId);
	
	public DataKey save(DataKey dataKey);
	
	public boolean exists(Long id);
	
	public void delete(Long id);
}
