package com.rodatek.common.business.service;

import java.util.Optional;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.persistence.PersistenceService;

public abstract class AbstractBusinessService<D extends IDto> implements BusinessService<D> {
	
	private PersistenceService<D> service;
	
	public AbstractBusinessService(PersistenceService<D> serv) {
		this.service = serv;
	}

	public D createDto(D dto) {		
		return service.create(dto);
	}

	@Override
	public Optional<D> findDtoById(Long id) {
		return service.findById(id);
	}

	@Override
	public D updateDto(D dto) {		
		return service.update(dto);
	}

	@Override
	public void deleteDtoById(Long id) {
		service.delete(id);
	}

}
 