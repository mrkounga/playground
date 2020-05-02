package com.rodatek.common.persistence;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.converter.Convertable;
import com.rodatek.common.model.IEntity;

public abstract class AbstractDtoEntityPersistenceService<D extends IDto, E extends IEntity> implements PersistenceDtoService<D>,Convertable<D, E> {
	
	protected  BaseRepository<E> repository;
	
	public AbstractDtoEntityPersistenceService(BaseRepository<E> repo) {
		this.repository = repo;
	}
}
