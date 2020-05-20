package com.rodatek.common.util.order;


import com.google.common.collect.Ordering;
import com.rodatek.common.interfaces.IWithName;

public final class OrderByName<T extends IWithName> extends Ordering<T> {

    public OrderByName() {
        super();
    }

    // API

    @Override
    public final int compare(final T left, final T right) {
        return left.getName().compareTo(right.getName());
    }

}
