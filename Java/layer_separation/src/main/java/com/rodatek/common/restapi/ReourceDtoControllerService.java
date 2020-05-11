package com.rodatek.common.restapi;

import com.rodatek.common.business.domain.IDto;

public interface ReourceDtoControllerService<R extends IResource, D extends IDto> extends ControllerService<R> {
	D convertResourceToDto(R resource);

	R convertDtoToResource(D dto);
}
