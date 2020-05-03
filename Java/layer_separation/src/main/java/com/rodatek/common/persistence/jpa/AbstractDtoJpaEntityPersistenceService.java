package com.rodatek.common.persistence.jpa;

import java.util.Optional;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.persistence.AbstractDtoEntityPersistenceService;


public  abstract class AbstractDtoJpaEntityPersistenceService<D extends IDto, E extends JpaEntity> extends AbstractDtoEntityPersistenceService<D,E> {
	
	protected  BaseJpaRepository<E> repository;
	
	public AbstractDtoJpaEntityPersistenceService(BaseJpaRepository<E> repo) {
		super(repo);
		this.repository=repo;
	}

	@Override
	public D create(D dto) {
		return convertToLayerObjectUp(repository.save(convertToLayerObjectDown(dto)));
	}

	@Override
	public Optional<D> findEntityById(Long id) {
		return Optional.of(convertToLayerObjectUp(repository.findById(id).get()));
	}

	@Override
	public D update(D dto) {
		return convertToLayerObjectUp(repository.save(convertToLayerObjectDown(dto)));
		
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
		
	}

}
