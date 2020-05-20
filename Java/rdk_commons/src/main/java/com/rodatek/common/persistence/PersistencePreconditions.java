package com.rodatek.common.persistence;

import com.rodatek.common.persistence.exception.MyEntityNotFoundException;
import com.rodatek.common.web.exception.MyBadRequestException;

public final class PersistencePreconditions {

    private PersistencePreconditions() {
        throw new AssertionError();
    }

    // API

    /**
     * Ensures that the entity reference passed as a parameter to the calling method is not null.
     * 
     * @param entity
     *            an object reference
     * @return the non-null reference that was validated
     * @throws MyEntityNotFoundException
     *             if {@code entity} is null
     */
    public static <T> T checkEntityExists(final T entity) {
        if (entity == null) {
            throw new MyEntityNotFoundException();
        }
        return entity;
    }

    public static void checkEntityExists(final boolean entityExists) {
        if (!entityExists) {
            throw new MyEntityNotFoundException();
        }
    }

    public static void checkOKArgument(final boolean okArgument) {
        if (!okArgument) {
            throw new MyBadRequestException();
        }
    }
    
    //to be implemented
    public static void checkArgumentDataType(final boolean okArgument) {
        if (!okArgument) {
            throw new MyBadRequestException();
        }
    }
    
    //Check if the entity is Valid
    

}
