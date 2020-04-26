package com.rodatek.common.converter;

import java.util.Optional;

import com.rodatek.common.domain.DtoService;
import com.rodatek.common.domain.IDto;
import com.rodatek.common.model.EntityService;
import com.rodatek.common.model.IEntity;

public abstract class AbstractDtoEntityConverter<D extends IDto, E extends IEntity> implements DtoService<D>,Convertable<D, E> {
	
	protected  EntityService<E> service;
	
	public AbstractDtoEntityConverter(EntityService<E> entityService) {
		this.service = entityService;
	}

	public D createDto(D dto) {
		return convertToLayerObjectUp(service.createEntity(convertToLayerObjectDown(dto)));
	}

	public Optional<D> getDtoById(Long id) {
		return Optional.of(convertToLayerObjectUp(service.getEntityById(id).get()));
	}

	
	
	
}
