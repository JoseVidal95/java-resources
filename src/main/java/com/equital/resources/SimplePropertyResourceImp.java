package com.equital.resources;

import com.equital.listeners.PropertyResourceListener;
import com.equital.models.ResourceApi;
import com.equital.models.SimplePropertyResource;

public final class SimplePropertyResourceImp<T>
        extends PropertyResourceImp<T, ResourceApi, PropertyResourceListener<T, ResourceApi>>
        implements SimplePropertyResource<T> {

    public SimplePropertyResourceImp(T value) {
        super(value);
    }

    @Override
    public ResourceApi api() {
        return null;
    }

}
