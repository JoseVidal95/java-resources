/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equital.resources.impl;

import com.equital.resources.models.IResource;
import com.equital.resources.models.IResourceData;
import com.utils.events.EventSubject;
import com.utils.events.IObserver;

/**
 *
 * @author jvidal
 */
public abstract class Resource<T, Api> extends EventSubject<T> implements IResource<T, Api> {

    protected T value;
    protected Api api;
    protected IResourceData data;

    public Resource(T value) {
        this.value = value;
        this.init();
    }

    @Override
    public IResourceData data() {
        return this.data;
    }

    void setData(IResourceData data) {
        this.data = data;
    }

    @Override
    public Api getApi() {
        return this.api;
    }

    void setApi(Api api) {
        this.api = api;
    }

    @Override
    public T getValue() {
        return this.value;
    }

    private void init() {
    }

    @Override
    public void attach(String event, IObserver<T> observer) {
        this.suscribe(event, observer);
    }

    @Override
    public void deattach(String event, IObserver<T> observer) {
        this.unsuscribe(event, observer);
    }
}
