package com.rodatek.common.persistence.converter;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.converter.Convertable;
import com.rodatek.common.model.IEntity;
import com.rodatek.common.repository.jpa.JpaEntity;


public interface DtoEntityConverter <D extends IDto, E extends IEntity> {// extends Convertable<D,E>{
	 D convertEntityToDto(E entity);
	 E  convertDtoToEntity(D dto);
}
	