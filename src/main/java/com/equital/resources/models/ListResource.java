package com.equital.resources.models;

import com.equital.resources.events.ListResourceListener;

public interface ListResource<T, L extends ListResourceListener<T, A>, A extends ResourceApi> extends Resource<A, L> {
    int size();

    void add(T value);

    void add(Iterable<T> values);

    T remove(int index);

    T first();

    T last();

    Iterable<T> get();

    void clear();

}
