package com.equital.resources.models;

import com.equital.resources.events.CollectionResourceListener;

import java.util.Map;

public interface CollectionResource<T, R extends PropertyResource<T, ?, ?>, I, L extends CollectionResourceListener<R, I, A>,
                                           A extends CollectionResourceApi<R, I>>
        extends PropertyResource<Iterable<I>, A, L> {

    int size();

    Iterable<R> list();

    Map<I, R> table();

    Iterable<T> valueList();

    Map<I, T> valueTable();

    R get(I id);

    boolean has(I id);

}
