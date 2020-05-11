package com.rodatek.common.business.service;


import java.util.List;
import java.util.Optional;

import com.rodatek.common.business.domain.IDto;

public interface BusinessService<D extends IDto> {
	
	D create(D dto);

	List<D> findAll();

	D update(D Dto);

	void deleteAll();
	
	void deleteById(String id);
	
	Optional<D> findById(String id);
	
	long count();
	
	List<D> saveAll(List<D> dtos);
	
	boolean exist(String id);
	
}
