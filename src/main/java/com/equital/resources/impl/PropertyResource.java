/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equital.resources.impl;

import com.equital.resources.models.IPropertyResource;
import java.util.Map;

/**
 *
 * @author jvidal
 */
public class PropertyResource<T, A> extends Resource<T, A> implements IPropertyResource<T, A> {

    public enum PropertyResourceEvents {
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

    @Override
    public void onChange(T value) {
        this.value = value;
        this.emit(PropertyResourceEvents.CHANGE);
    }

    @Override
    public <K, V> void changeData(Map<K, V> data) {
        // TODO
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void emit(PropertyResourceEvents event) {
        super.emit(event.getValue(), this.value);
    }

}
