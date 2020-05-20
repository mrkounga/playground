package com.rodatek.common.converter;

import com.rodatek.common.base.domain.dto.BaseDto;
import com.rodatek.common.base.model.entity.BaseEntity;

public interface Converter<D extends BaseDto, E extends BaseEntity > {
	D convertEntityToDto(E entity);
	E convertDtoToEntity(D dto);
}
