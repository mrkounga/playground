package com.rodatek.common.restapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.business.service.BusinessService;
import com.rodatek.common.converter.Convertable;

public abstract class AbstractResourceToDtoService<R extends IResource, D extends IDto>
		implements ReourceDtoControllerService<R,D> {

	protected final BusinessService<D> service;
	
	protected AbstractResourceToDtoService(BusinessService<D> serv) {
		this.service=serv;
	}

	@Override
	public R createResource(R resource) {
		return convertDtoToResource(service.create(convertResourceToDto(resource)));
	}

	@Override
	public Optional<R> findRessourceById(String id) {
		return Optional.of(convertDtoToResource(service.findById(id).get()));
	}

	@Override
	public void deleteResourceById(String id) {
		service.deleteById(id);
		
	}

	@Override
	public R updateResource(R resource) {
		return convertDtoToResource(service.create(convertResourceToDto(resource)));
	}

	@Override
	@Profile(value = {"dev","local"})
	public List<R> findAllResource() {
		List<R> resources = new ArrayList<R>();
		service.findAll().forEach(dto -> resources.add(convertDtoToResource(dto)));
		return resources;
	}

	@Override
	@Profile(value = {"dev","local"})
	public void deleteAllResource() {
		service.deleteAll();
	}

	@Override
	public long count() {		
		return service.count();
	}

	@Override
	public List<R> saveAllResource(List<R> resources) {
		List<R> resourceObjects=new ArrayList<R>();
		List<D> savedDtos=new ArrayList<D>();
		resources.forEach(ro ->savedDtos.add(convertResourceToDto(ro)));
		service.saveAll(savedDtos).forEach(dto->resourceObjects.add(convertDtoToResource(dto)));
		return resourceObjects;
	}

	@Override
	public boolean exist(String id) {		
		return service.exist(id);
	}


}
