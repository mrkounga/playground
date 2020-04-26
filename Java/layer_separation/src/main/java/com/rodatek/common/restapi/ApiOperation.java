package com.rodatek.common.restapi;

import java.util.Optional;

public interface ApiOperation<R extends IResource>{
	R createResource(R resource);
	Optional<R> getResource(Long id);
}
