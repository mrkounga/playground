package com.rodatek.common.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import com.rodatek.common.model.JpaEntity;


@NoRepositoryBean
public interface BaseJpaRepository<E extends JpaEntity> extends JpaRepository<E, Long>, JpaSpecificationExecutor<E> {
	
}