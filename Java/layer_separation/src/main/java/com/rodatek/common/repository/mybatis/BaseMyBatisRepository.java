package com.rodatek.common.repository.mybatis;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;

import com.rodatek.common.model.SqlEntity;
import com.rodatek.common.repository.BaseRepository;

@NoRepositoryBean
public interface BaseMyBatisRepository<E extends SqlEntity> extends BaseRepository<E> {

	List<E> findAll();

	Optional<E> findById(long id);

	boolean deleteById(long id);

	int save(E entity);

	boolean update(E entity);

	int count();
	
	boolean deleteAll();
}
