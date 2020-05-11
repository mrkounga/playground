package com.rodatek.common.persistence.converter;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.model.JpaEntity;

public interface DtoToJpaEntityConverter<D extends IDto,E extends JpaEntity>  extends DtoEntityConverter<D, E>{

}
