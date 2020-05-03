package com.rodatek.common.persistence.jpa;

import java.util.Optional;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.converter.Convertable;
import com.rodatek.common.persistence.AbstractDtoEntityPersistenceService;
import com.rodatek.common.persistence.BaseRepository;
import com.rodatek.common.persistence.PersistenceDtoService;
import com.rodatek.common.repository.jpa.BaseJpaRepository;
import com.rodatek.common.repository.jpa.JpaEntity;

public  abstract class AbstractDtoJpaEntityPersistenceService<D extends IDto, E extends JpaEntity> extends AbstractDtoEntityPersistenceService<D,E> {

	protected BaseJpaRepository<E> repository;
	
	
	public AbstractDtoJpaEntityPersistenceService(BaseRepository<E> repo) {
		super(repo);
		
	}

	@Override
	public D create(D dto) {
		return convertToLayerObjectUp(repository.save(convertToLayerObjectDown(dto)));
	}

	@Override
	public Optional<D> findById(Long id) {
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
