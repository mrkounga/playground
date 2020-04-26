package com.rodatek.common.domain;

import java.util.Optional;

public interface BusinessOperation<D extends IDto> {
	D createDto(D dto);
	Optional<D> getDtoById(Long id);

}
