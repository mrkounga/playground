package com.rodatek.common.persistence.converter;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.model.IEntity;


public interface DtoEntityConverter <D extends IDto, E extends IEntity> {
	 D convertEntityToDto(E entity);
	 E  convertDtoToEntity(D dto);
}
	