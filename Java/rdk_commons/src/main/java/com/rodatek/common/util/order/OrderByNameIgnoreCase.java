package com.rodatek.common.util.order;


import com.google.common.collect.Ordering;
import com.rodatek.common.persistence.model.INameableEntity;

public final class OrderByNameIgnoreCase<T extends INameableEntity> extends Ordering<T> {

    public OrderByNameIgnoreCase() {
        super();
    }

    // API

    @Override
    public final int compare(final T left, final T right) {
        return left.getName().compareToIgnoreCase(right.getName());
    }

}
