package com.rodatek.common.persistence.jpa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rodatek.common.persistence.PersistenceService;

@Service
@Qualifier("jpa")
public abstract class AbstractPersistenceJpaEntityService< E extends JpaEntity> implements PersistenceService<E> {

	protected BaseJpaRepository<E> repository;
	
	public AbstractPersistenceJpaEntityService(BaseJpaRepository<E> repository) {
		this.repository = repository;
	}
	
	public E SaveEntity(E entity) {
		return repository.save(entity);	
	}

	public Optional<E> findEntityById(Long id) {		
		return repository.findById(id);
	}

}
