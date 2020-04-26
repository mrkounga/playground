package com.rodatek.common.converter;

import com.rodatek.common.domain.IDto;
import com.rodatek.common.model.IEntity;


public interface DtoEntityConverter <D extends IDto, E extends IEntity>  extends Convertable<D,E>{

}
	