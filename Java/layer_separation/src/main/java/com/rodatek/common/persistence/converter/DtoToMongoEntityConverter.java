package com.rodatek.common.persistence.converter;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.model.MongoEntity;

public interface DtoToMongoEntityConverter<D extends IDto,E extends MongoEntity>  extends DtoEntityConverter<D, E>{

}
