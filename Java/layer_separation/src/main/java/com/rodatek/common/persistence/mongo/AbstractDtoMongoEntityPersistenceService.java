package com.rodatek.common.persistence.mongo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.persistence.AbstractDtoEntityPersistenceService;
import com.rodatek.common.persistence.BaseRepository;
import com.rodatek.common.repository.mongo.BaseMongoRepository;
import com.rodatek.common.repository.mongo.MongoEntity;

@Service
@Qualifier("jpa")
public abstract class AbstractDtoMongoEntityPersistenceService<D extends IDto, E extends MongoEntity> extends AbstractDtoEntityPersistenceService<D,E> {
	
	
	public AbstractDtoMongoEntityPersistenceService(BaseRepository<E> repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}

	protected  BaseMongoRepository<E> repository;
	
	
	
	
	/*
	 * public D createDto(D dto) { return
	 * convertToLayerObjectUp(repository.save(convertToLayerObjectDown(dto))); }
	 * 
	 * public Optional<D> getDtoById(Long id) { return
	 * Optional.of(convertToLayerObjectUp(repository.findById(id).get())); }
	 */

}
