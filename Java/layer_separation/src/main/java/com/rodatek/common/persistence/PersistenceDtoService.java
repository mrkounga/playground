package com.rodatek.common.persistence;

import com.rodatek.common.business.domain.IDto;

public interface PersistenceDtoService<D extends IDto> extends PersistenceDtoOperation<D> {

}
