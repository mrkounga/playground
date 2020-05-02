package com.rodatek.common.converter;

import java.util.Optional;

import com.rodatek.common.domain.DtoService;
import com.rodatek.common.domain.IDto;
import com.rodatek.common.restapi.IResource;
import com.rodatek.common.restapi.ResourceService;


public abstract class AbstractResourceDtoConverter<R extends IResource, D extends IDto> implements ResourceService<R>, ResourceDtoConverter<R, D>{
	
	protected DtoService<D> dtoService;
	
	public AbstractResourceDtoConverter(DtoService<D> dService ) {
		this.dtoService=dService;
	}

	public R createResource(R resource) {
		return convertToLayerObjectUp(dtoService.createDto(convertToLayerObjectDown(resource)));
		
	}

	public Optional<R> getResource(Long id) {
		return Optional.of(convertToLayerObjectUp(dtoService.getDtoById(id).get()));
	}

	
	
}
