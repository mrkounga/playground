package com.rodatek.common.repository.mybatis;

import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;

import com.rodatek.common.model.IEntity;
import com.rodatek.common.repository.BaseRepository;

@NoRepositoryBean
public interface BaseMyBatisRepository<E extends IEntity> extends BaseRepository<E>{
	E save(E entity);
	Optional<E> findById(Long id);
	void deleteById(Long id);

}
