package com.rodatek.common.converter;
import java.util.Optional;

import org.modelmapper.ModelMapper;

import com.rodatek.common.interfaces.INameableDto;
import com.rodatek.common.persistence.model.INameableEntity;

public  class AbstractDtoEntityConverter<D extends INameableDto, E extends INameableEntity> implements IDtoJpaEntityConverterService<D, E> {
	
	
	protected ModelMapper modelMapper; 
	protected D dto;
	protected E entity;
	
	
	public AbstractDtoEntityConverter(ModelMapper mapper, D dto, E entity) {
		this.modelMapper=mapper;
		this.dto=dto;
		this.entity=entity;
	}
	

	


	@Override
	public Optional<D> convertToDto(E entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Optional<E> convertToEntity(D dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
