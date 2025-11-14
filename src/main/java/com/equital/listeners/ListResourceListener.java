package com.equital.listeners;

import com.equital.models.ResourceApi;

public interface ListResourceListener<T, A extends ResourceApi> extends ResourceListener<A> {
    void add(Iterable<T> values);

    void remove(Iterable<T> values);

    void change(Iterable<T> value);
}
