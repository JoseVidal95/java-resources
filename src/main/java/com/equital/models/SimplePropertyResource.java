package com.equital.models;

import com.equital.listeners.PropertyResourceListener;

public interface SimplePropertyResource<T>
        extends PropertyResource<T, ResourceApi, PropertyResourceListener<T, ResourceApi>> {
}
