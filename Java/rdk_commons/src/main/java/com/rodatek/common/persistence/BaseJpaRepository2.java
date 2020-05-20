/**
 * 
 */
package com.rodatek.common.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import com.rodatek.common.interfaces.IByNameApi;
import com.rodatek.common.persistence.model.INameableEntity;

/**
 * @author koungam
 *
 */
@NoRepositoryBean
public interface BaseJpaRepository2<E extends INameableEntity> extends JpaRepository<E, Long>, JpaSpecificationExecutor<E>, IByNameApi<E> {
	E findByName(String name);

	
}
