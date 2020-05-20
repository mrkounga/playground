package com.rodatek.common.persistence;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.rodatek.common.base.BaseObject;

@NoRepositoryBean
public interface BaseRepository<E extends BaseObject> extends PagingAndSortingRepository<E, Serializable>, QueryByExampleExecutor<E> {
	E  findByName(String name);
}
