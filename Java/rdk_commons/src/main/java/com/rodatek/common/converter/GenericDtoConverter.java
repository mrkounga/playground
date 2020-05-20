package com.rodatek.common.converter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.rodatek.common.interfaces.INameableDto;
import com.rodatek.common.persistence.model.INameableEntity;

public interface GenericDtoConverter<D extends INameableDto, E extends INameableEntity> {

	D convertToDto(E entity);

	E convertToEntity(D dto);

	default List<D> createFromEntities(final Collection<E> entities) {
		return entities.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	default List<E> createFromDtos(final Collection<D> dtos) {
		return dtos.stream().map(this::convertToEntity).collect(Collectors.toList());
	}
}
