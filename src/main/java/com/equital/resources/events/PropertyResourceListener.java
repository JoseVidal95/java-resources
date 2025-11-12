package com.equital.resources.events;

import com.equital.resources.models.ResourceApi;

public interface PropertyResourceListener<T, A extends ResourceApi> extends ResourceListener<A> {
    void change(T value);
}
