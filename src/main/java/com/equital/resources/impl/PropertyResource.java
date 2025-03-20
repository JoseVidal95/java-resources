/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equital.resources.impl;

import com.equital.resources.constants.models.IResourceEvents;
import com.equital.resources.models.IPropertyResource;
import com.equital.resources.models.IResourceApi;
import com.equital.resources.models.IResourceData;

/**
 *
 * @author jvidal
 */
public abstract class PropertyResource<T, A extends IResourceApi> extends Resource<T, A> implements IPropertyResource<T, A> {

    private static final long serialVersionUID = 7325316480150501292L;

    public enum PropertyResourceEvents implements IResourceEvents {
        CHANGE("change");

        private final String value;

        private PropertyResourceEvents(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    public PropertyResource(T value) {
        super(value);
    }

    public PropertyResource(T value, IResourceData data) {
        super(value, data);
    }

    public PropertyResource(T value, A api) {
        super(value, api);
    }

    public PropertyResource(T value, A api, IResourceData data) {
        super(value, api, data);
    }

    @Override
    public void onChange(T value) {
        this.setValue(value);
        this.emit(PropertyResourceEvents.CHANGE);
    }

    @Override
    public <K, V> void changeData(T item, IResourceData data) {
        this.data().set(data.all());
        this.onChange(item);
    }

}
