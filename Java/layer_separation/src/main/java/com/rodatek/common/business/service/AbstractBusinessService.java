package com.rodatek.common.business.service;

import java.util.List;
import java.util.Optional;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.persistence.PersistenceService;


public  abstract class AbstractBusinessService<D extends IDto> implements BusinessService<D> {
	
	protected PersistenceService<D> service;
	
	public AbstractBusinessService(PersistenceService<D> serv) {
		this.service = serv;
	}

	@Override
	public D create(D dto) {		
		return service.create(dto);
	}

	@Override
	public List<D> findAll() {		
		return service.findAll();
	}

	@Override
	public D update(D Dto) {
		return service.update(Dto);
	}

	@Override
	public void deleteAll() {
		service.deleteAll();
		
	}

	@Override
	public long count() {		
		return service.count();
	}

	@Override
	public List<D> saveAll(List<D> dtos) {
		return service.saveAll(dtos);
	}

	@Override
	public boolean exist(String id) {		
		return service.exist(id);
	}

	@Override
	public void deleteById(String id) {
		service.deleteById(id);
		
	}

	@Override
	public Optional<D> findById(String id) {
		return service.findById(id);
	}
	

}
 