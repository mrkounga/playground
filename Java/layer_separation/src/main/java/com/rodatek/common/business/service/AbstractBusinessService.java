package com.rodatek.common.business.service;

import java.util.Optional;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.persistence.PersistenceDtoService;

public class AbstractBusinessService<D extends IDto> implements BusinessService<D> {
	
	private PersistenceDtoService<D> service;
	
	public AbstractBusinessService(PersistenceDtoService<D> serv) {
		this.service = serv;
	}

	public D createDto(D dto) {		
		return service.create(dto);
	}

	public Optional<D> getDtoById(Long id) {		
		return service.findEntityById(id);
	}

}
 