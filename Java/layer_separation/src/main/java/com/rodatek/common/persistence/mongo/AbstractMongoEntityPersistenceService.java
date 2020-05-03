package com.rodatek.common.persistence.mongo;

import java.util.Optional;

import com.rodatek.common.persistence.PersistenceService;
import com.rodatek.common.repository.mongo.BaseMongoRepository;
import com.rodatek.common.repository.mongo.MongoEntity;

//@Service
//@Qualifier("mongo")
public class AbstractMongoEntityPersistenceService<E extends MongoEntity> implements PersistenceService<E>{
	
	protected BaseMongoRepository<E> repository;
	
	public AbstractMongoEntityPersistenceService(BaseMongoRepository<E> repository) {
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
