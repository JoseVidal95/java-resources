package com.equital.resources.models;

import com.equital.resources.events.PropertyResourceListener;

public interface PropertyResource<T, A extends ResourceApi, L extends PropertyResourceListener<T, A>>
        extends Resource<A, L> {
    T get();

    void set(T value);
}
