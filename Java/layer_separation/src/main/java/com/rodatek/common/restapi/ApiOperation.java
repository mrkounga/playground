package com.rodatek.common.restapi;

import java.util.Optional;

public interface ApiOperation<R extends IResource>{
	R createResource(R resource);
	Optional<R> findRessourceById(Long id);
	void deleteResourceById(Long id);
	R updateResource(R resource);
}
