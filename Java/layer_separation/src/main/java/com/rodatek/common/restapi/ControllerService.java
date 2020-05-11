package com.rodatek.common.restapi;

import java.util.List;
import java.util.Optional;

public interface ControllerService<R extends IResource> {
	
	R createResource(R resource);

	Optional<R> findRessourceById(String id);

	void deleteResourceById(String id);

	R updateResource(R resource);

	List<R> findAllResource();

	void deleteAllResource();

	long count();

	List<R> saveAllResource(List<R> reosurces);

	boolean exist(String id);

}
