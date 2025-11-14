package com.equital.models;

import com.equital.listeners.ListResourceListener;

public interface ListResource<T, L extends ListResourceListener<T, A>, A extends ResourceApi> extends Resource<A, L> {

    int size();

    void add(T value);

    void add(Iterable<T> values);

    T remove(int index);

    T first();

    T last();

    Iterable<T> get();

    T get(int index);

    void clear();

}
