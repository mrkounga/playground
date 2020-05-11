package com.rodatek.common.persistence;


import java.util.List;
import java.util.Optional;

import com.rodatek.common.business.domain.IDto;

public interface PersistenceService<D extends IDto> {

	D create(D dto);

	List<D> findAll();

	D update(D Dto);

	void deleteAll();
	
	long count();
	
	List<D> saveAll(List<D> dtos);
	

	void deleteById(String id);

	Optional<D> findById(String id);

	boolean exist(String id);

	
}
