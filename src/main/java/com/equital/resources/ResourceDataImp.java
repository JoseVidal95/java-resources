package com.equital.resources;

import com.equital.models.ResourceData;

class ResourceDataImp<T> implements ResourceData<T> {
    private T data;

    @Override
    public void set(T data) {
        this.data = data;
    }

    @Override
    public T get() {
        return this.data;
    }
}
