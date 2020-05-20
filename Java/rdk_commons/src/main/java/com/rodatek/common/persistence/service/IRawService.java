package com.rodatek.common.persistence.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.rodatek.common.interfaces.IOperations;
import com.rodatek.common.interfaces.IWithName;

public interface IRawService<T extends IWithName> extends IOperations<T> {

	Page<T> findAllPaginatedAndSortedRaw(final int page, final int size, final String sortBy, final String sortOrder);

	Page<T> findAllPaginatedRaw(final int page, final int size);

}
