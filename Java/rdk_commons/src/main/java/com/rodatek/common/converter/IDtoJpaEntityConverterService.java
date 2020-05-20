/**
 * 
 */
package com.rodatek.common.converter;

import java.util.Optional;

import com.rodatek.common.interfaces.INameableDto;
import com.rodatek.common.persistence.model.INameableEntity;

/**
 * @author koungam
 *
 */
public interface IDtoJpaEntityConverterService<D extends INameableDto, E extends INameableEntity> {
		
	Optional<D> convertToDto(E entity);

	Optional<E> convertToEntity(D dto);

}
