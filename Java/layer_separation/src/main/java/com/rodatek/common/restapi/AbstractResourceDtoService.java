package com.rodatek.common.restapi;

import java.util.Optional;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.business.service.BusinessService;
import com.rodatek.common.converter.Convertable;

public abstract class AbstractResourceDtoService<R extends IResource, D extends IDto>
		implements ControllerService<R>, Convertable<R, D> {

	protected final BusinessService<D> service;

	public AbstractResourceDtoService(BusinessService<D> serviceToSet) {
		this.service = serviceToSet;
	}

	@Override
	public R createResource(R resource) {
		return convertToLayerObjectUp(service.createDto(convertToLayerObjectDown(resource)));
	}

	@Override
	public Optional<R> findRessourceById(Long id) {
		return Optional.of(convertToLayerObjectUp(service.findDtoById(id).get()));
	}

	@Override
	public void deleteResourceById(Long id) {
		service.deleteDtoById(id);

	}

	@Override
	public R updateResource(R resource) {
		return convertToLayerObjectUp(service.updateDto(convertToLayerObjectDown(resource)));
	}

}
