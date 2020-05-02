package com.rodatek.common.persistence.converter;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.converter.Convertable;
import com.rodatek.common.model.IEntity;


public interface DtoEntityConverter <D extends IDto, E extends IEntity>  extends Convertable<D,E>{

}
	