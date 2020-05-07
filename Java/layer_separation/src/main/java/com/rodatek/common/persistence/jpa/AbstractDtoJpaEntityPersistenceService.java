package com.rodatek.common.persistence.jpa;

import java.util.Optional;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.model.IEntity;
import com.rodatek.common.persistence.AbstractDtoEntityPersistenceService;
import com.rodatek.common.repository.jpa.BaseJpaRepository;


public abstract class AbstractDtoJpaEntityPersistenceService<D extends IDto, E extends IEntity> extends AbstractDtoEntityPersistenceService<D,E> {
	
	protected final BaseJpaRepository<E> repository;
	
	protected AbstractDtoJpaEntityPersistenceService(BaseJpaRepository<E> repository) {
		super(repository);
		this.repository=repository;
		// TODO Auto-generated constructor stub
	}

	

	/*
	 * public AbstractDtoJpaEntityPersistenceService(BaseJpaRepository<E>
	 * jpaRepository) {
	 * 
	 * this.repository= jpaRepository; }
	 */
	
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
