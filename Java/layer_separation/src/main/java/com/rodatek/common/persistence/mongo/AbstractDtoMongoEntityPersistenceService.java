package com.rodatek.common.persistence.mongo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.model.IEntity;
import com.rodatek.common.persistence.AbstractDtoEntityPersistenceService;
import com.rodatek.common.persistence.PersistenceService;
import com.rodatek.common.repository.BaseRepository;
import com.rodatek.common.repository.mongo.BaseMongoRepository;
import com.rodatek.common.repository.mongo.MongoEntity;

//@Service
//@Qualifier("jpa")
public abstract class AbstractDtoMongoEntityPersistenceService<D extends IDto, E extends IEntity> extends AbstractDtoEntityPersistenceService<D,E>{
	
	protected  BaseMongoRepository<E> repository;
	
	protected AbstractDtoMongoEntityPersistenceService(BaseMongoRepository<E> repository) {
		super(repository);
		this.repository=repository;
	}

	@Override
	public void delete(Long id) {
		// Persistence service : precondition check to be implemented
		repository.deleteById(id);
	}

	@Override
	public D create(D dto) {
		//Persistence service : precondition check  to be implemented
		return  convertEntityToDto(repository.save(convertDtoToEntity(dto))); 
	}

	@Override
	public Optional<D> findById(Long id) {
		//Persistence service :   precondition check to be implemented
		return Optional.of(convertEntityToDto(repository.findById(id).get()));
		
	}

	@Override
	public D update(D dto) {
		// Persistence service : precondition check  to be implemented
		return convertEntityToDto(repository.save(convertDtoToEntity(dto))); 
	}


}
