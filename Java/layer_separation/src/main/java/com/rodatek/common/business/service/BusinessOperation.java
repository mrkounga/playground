package com.rodatek.common.business.service;

import java.util.Optional;

import com.rodatek.common.business.domain.IDto;

public interface BusinessOperation<D extends IDto> {
	D createDto(D dto);
	Optional<D> getDtoById(Long id);
}
