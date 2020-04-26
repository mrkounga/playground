package com.rodatek.common.base;

import java.util.List;
import java.util.Optional;



public interface BaseOperation< B extends BaseObject> {

    // find - one

   Optional <B> findOne(final long id);

    /**
     * - contract: if nothing is found, an empty list will be returned to the calling client <br>
     */
   
    List<B> findAll();

  
    /**
     * - contract: if nothing is found, an empty list will be returned to the calling client <br>
     */
    List<B> findAllPaginated(final int page, final int size);

    /**
     * - contract: if nothing is found, an empty list will be returned to the calling client <br>
     */
    List<B> findAllPaginatedAndSorted(final int page, final int size, final String sortBy, final String sortOrder);

    // create

    B create(final B object);

    // update

    void update(final B object);

    // delete

    void delete(final long id);

    void deleteAll();

    // count

    long count();

}
