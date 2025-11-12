package com.equital.resources.impl;

import com.equital.resources.events.PropertyResourceListener;
import com.equital.resources.events.ResourceEvents;
import com.equital.resources.models.PropertyResource;
import com.equital.resources.models.ResourceApi;

public abstract class PropertyResourceImp<T, A extends ResourceApi, L extends PropertyResourceListener<T, A>>
        extends ResourceImp<L, A> implements PropertyResource<T, A, L> {

    private T value;

    public PropertyResourceImp(T value) {
        super();
        this.set(value);
    }

    @Override
    public T get() {
        return value;
    }

    @Override
    public void set(T value) {
        this.value = value;
        this.onChange();
    }

    protected void onChange() {
        this.listeners(ResourceEvents.UPDATE).forEach(listener -> listener.change(this.get()));
    }

}
