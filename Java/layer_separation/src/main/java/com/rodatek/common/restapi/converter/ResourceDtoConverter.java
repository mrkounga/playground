package com.rodatek.common.restapi.converter;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.converter.Convertable;
import com.rodatek.common.restapi.IResource;

public interface ResourceDtoConverter<R extends IResource,D extends IDto> {
	D convertResourceToDto(R resource);
	R convertDtoToResource(D dto);
}
