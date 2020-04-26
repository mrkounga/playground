package com.rodatek.common.converter;

import com.rodatek.common.domain.IDto;
import com.rodatek.common.restapi.IResource;

public interface ResourceDtoConverter<R extends IResource,D extends IDto> extends Convertable<R, D> {
	
}
