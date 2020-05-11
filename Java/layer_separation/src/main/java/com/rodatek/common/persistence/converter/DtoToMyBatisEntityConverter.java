package com.rodatek.common.persistence.converter;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.model.SqlEntity;



public interface DtoToMyBatisEntityConverter<D extends IDto,E extends SqlEntity>  extends DtoEntityConverter<D, E>{

}
