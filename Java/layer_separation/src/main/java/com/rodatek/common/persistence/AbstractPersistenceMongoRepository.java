package com.rodatek.common.persistence;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rodatek.common.model.MongoEntity;

@Service
@Qualifier("mongo")
public class AbstractPersistenceMongoRepository<E extends MongoEntity> implements PersistenceService<E>{
	
	protected BaseMongoRepository<E> repository;
	
	public AbstractPersistenceMongoRepository(BaseMongoRepository<E> repository) {
		this.repository = repository;
	}

	public E SaveEntity(E entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<E> findEntityById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
