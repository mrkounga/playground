package com.rodatek.common.persistence.mongo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.model.MongoEntity;
import com.rodatek.common.repository.mongo.BaseMongoRepository;

public abstract class AbstractDtoMongoEntityPersistenceService<D extends IDto, E extends MongoEntity>
		implements PersistenceMongoEntityService<D, E> {

	protected BaseMongoRepository<E> repository;

	protected AbstractDtoMongoEntityPersistenceService(BaseMongoRepository<E> repository) {

		this.repository = repository;
	}

	@Override
	public void deleteById(String id) {
		// Persistence service : precondition check to be implemented
		repository.deleteById(id);
	}

	@Override
	public void deleteAll() {
		// Persistence service : precondition check to be implemented
		repository.deleteAll();
	}

	@Override
	public List<D> findAll() {
		// Persistence service : precondition check to be implemented
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
		// Persistence service : precondition check to be implemented
		return Optional.of(convertEntityToDto(repository.findById(id).get()));

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
	public List<D> saveAll(List<D> dtos) {
		// Persistence service : precondition check to be implemented
		List<E> entities = new ArrayList<E>();
		List<D> savedDtos = new ArrayList<D>();
		dtos.forEach(dto -> entities.add(convertDtoToEntity(dto)));
		repository.saveAll(entities).forEach(entity -> savedDtos.add(convertEntityToDto(entity)));
		return savedDtos;
	}

	@Override
	public boolean exist(String id) {
		return repository.existsById(id);

	}

}
