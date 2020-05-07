package com.rodatek.common.persistence;



import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.model.IEntity;
import com.rodatek.common.persistence.converter.DtoEntityConverter;
import com.rodatek.common.repository.BaseRepository;


public abstract class AbstractDtoEntityPersistenceService<D extends IDto, E extends IEntity> implements PersistenceService<D>, DtoEntityConverter<D, E> {
	
	protected   BaseRepository<E> repository;
	
	protected AbstractDtoEntityPersistenceService(BaseRepository<E> repository) {
		this.repository=repository;
	}

}
