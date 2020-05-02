package com.rodatek.common.restapi;

import java.util.Optional;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.business.service.BusinessService;
import com.rodatek.common.converter.Convertable;


public abstract class AbstractResourceDtoService<R extends IResource, D extends IDto> implements ResourceService<R>,Convertable<R, D> {
	
	protected  BusinessService<D> service;
	
	public AbstractResourceDtoService(BusinessService<D> serviceToSet) {
		this.service=serviceToSet;
	}

	@Override
	public R createResource(R resource) {
		return convertToLayerObjectUp(service.createDto(convertToLayerObjectDown(resource)));
	}

	@Override
	public Optional<R> getResource(Long id) {
		return Optional.of(convertToLayerObjectUp(service.getDtoById(id).get()));
	}
}
