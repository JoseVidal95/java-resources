package com.equital.resources;

import com.equital.events.ResourceEvents;
import com.equital.listeners.PropertyResourceListener;
import com.equital.models.PropertyResource;
import com.equital.models.ResourceApi;
import com.sun.istack.Nullable;

public class PropertyResourceImp<T, A extends ResourceApi, L extends PropertyResourceListener<T, A>>
        extends ResourceImp<L, A> implements PropertyResource<T, A, L> {

    private T value;

    public PropertyResourceImp(@Nullable T value) {
        this.set(value);
    }

    @Override
    public T get() {
        return value;
    }

    @Override
    public void set(@Nullable T value) {
        this.value = value;
        this.onChange();
    }

    protected void onChange() {
        this.listeners(ResourceEvents.UPDATE).forEach(listener -> listener.change(this.get()));
    }

}
