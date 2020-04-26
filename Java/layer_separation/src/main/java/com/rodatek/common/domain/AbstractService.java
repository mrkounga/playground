package com.rodatek.common.domain;

import java.util.Optional;

public class AbstractService<D extends IDto> implements BusinessOperation<D> {
	
	private DtoService<D> service;
	
	public AbstractService(DtoService<D> serv) {
		this.service = serv;
	}

	public D createDto(D dto) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<D> getDtoById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
 