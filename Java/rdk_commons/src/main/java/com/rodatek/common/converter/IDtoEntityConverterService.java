/**
 * 
 */
package com.rodatek.common.converter;

import com.rodatek.common.base.domain.dto.BaseDto;
import com.rodatek.common.base.model.entity.BaseEntity;

/**
 * @author koungam
 *
 */
public interface IDtoEntityConverterService<D extends BaseDto, E extends BaseEntity>  
extends IConverterService<D, E>{

}
