/**
 * 
 */
package com.rodatek.common.persistence;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.rodatek.common.base.model.entity.BaseJpaEntity;

/**
 * @author koungam
 *
 */

@NoRepositoryBean
public interface BaseJpaRepository<E extends BaseJpaEntity> extends JpaRepository<E, Serializable>, BaseRepository<E> {

}
