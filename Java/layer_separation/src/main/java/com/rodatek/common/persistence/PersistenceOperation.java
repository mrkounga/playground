package com.rodatek.common.persistence;

import java.util.Optional;

import com.rodatek.common.business.domain.IDto;


public interface PersistenceOperation<D extends IDto> {
	
	D create(D dto);

	Optional<D> findById(Long id);

	D update(D Dto);

	void delete(Long id);
}
