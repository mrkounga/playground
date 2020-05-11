package com.rodatek.common.persistence.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.model.JpaEntity;
import com.rodatek.common.repository.jpa.BaseJpaRepository;


public  abstract class AbstractDtoJpaEntityPersistenceService<D extends IDto, E extends JpaEntity>
		implements PersistenceJpaEntityService<D,E> {
	

	protected final BaseJpaRepository<E> repository;

	protected AbstractDtoJpaEntityPersistenceService(BaseJpaRepository<E> repository) {
		this.repository = repository;
	}

	


	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

	@Override
	public List<D> findAll() {
		List<D> dtos = new ArrayList<D>();
		repository.findAll().forEach(e -> dtos.add(convertEntityToDto(e)));
		return dtos;
	}

	@Override
	public D create(D dto) {
		// Persistence service : precondition check to be implemented
		return convertEntityToDto(repository.save(convertDtoToEntity(dto)));
	}

	@Override
	public Optional<D> findById(String id) {
		
		return Optional.of(convertEntityToDto(repository.findById(Long.parseLong(id)).get()));

	}

	@Override
	public D update(D dto) {
		// Persistence service : precondition check to be implemented
		return convertEntityToDto(repository.save(convertDtoToEntity(dto)));
	}



	@Override
	public long count() {
		
		return repository.count();
	}


	@Override
	public void deleteById(String id) {
		repository.deleteById(Long.parseLong(id));
		
	}

	@Override
	public List<D> saveAll(List<D> dtos) {
		List<E> entities=new ArrayList<E>();
		List<D> savedDtos=new ArrayList<D>();
		dtos.forEach(dto ->entities.add(convertDtoToEntity(dto)));
		repository.saveAll(entities).forEach(entity->savedDtos.add(convertEntityToDto(entity)));
		return savedDtos;
	}

	@Override
	public boolean exist(String id) {
		return repository.existsById(Long.parseLong(id));
	}

}
