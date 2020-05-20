package com.rodatek.common.service;

import java.util.List;

import com.rodatek.common.base.BaseObject;


public interface BaseService<O extends BaseObject> {
	O create(O e);
	O update(Long id);
	List<O> getAll();
	List<O> findPaginated(int pageNo, int pageSize);
	O findByName(String name);
	O findById(long id);
	void delete(long id);
	void delete(O e);
	long count();
	
	
	
	
	
	
	
	
	
	

}
