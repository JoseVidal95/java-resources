package com.equital.listeners;

import com.equital.models.ResourceApi;

public interface PropertyResourceListener<T, A extends ResourceApi> extends ResourceListener<A> {
    void change(T value);
}
