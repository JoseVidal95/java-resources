/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equital.resources.impl;

import com.equital.resources.models.ILoadableResource;
import com.equital.resources.models.ILoadableResourceApi;
import com.utils.events.IObserver;

/**
 *
 * @author jvidal
 */
public class LoadableResource<T, A extends ILoadableResourceApi> extends Resource<T, A> implements ILoadableResource<T, A> {

    public enum LoadableResourceEvents {
        LOADING("loading"),
        LOADED("loaded");

        private final String value;

        private LoadableResourceEvents(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    public LoadableResource(T value) {
        super(value);
    }

    @Override
    public void onLoading() {
        this.emit(LoadableResourceEvents.LOADING);
    }

    @Override
    public void onLoaded() {
        this.emit(LoadableResourceEvents.LOADED);
    }

    public void attach(LoadableResourceEvents event, IObserver<T> observer) {
        this.suscribe(event.getValue(), observer);
    }

    public void deattach(LoadableResourceEvents event, IObserver<T> observer) {
        this.unsuscribe(event.getValue(), observer);
    }

    private void emit(LoadableResourceEvents event) {
        super.emit(event.getValue(), this.value);
    }
}
