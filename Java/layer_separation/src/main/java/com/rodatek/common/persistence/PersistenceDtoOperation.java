package com.rodatek.common.persistence;

import java.util.Optional;

import com.rodatek.common.business.domain.IDto;

public interface PersistenceDtoOperation<D extends IDto> {
	D create(D dto);
	Optional<D> findEntityById(Long id);
	D update(D Dto);
	void delete(Long id);
}
