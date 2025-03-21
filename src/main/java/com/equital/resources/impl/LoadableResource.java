/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equital.resources.impl;

import com.equital.resources.constants.models.IResourceEvents;
import com.equital.resources.models.ILoadableResource;
import com.equital.resources.models.ILoadableResourceApi;
import java.util.Date;

/**
 *
 * @author jvidal
 */
public abstract class LoadableResource<T, A extends ILoadableResourceApi>
        extends PropertyResource<T, A>
        implements ILoadableResource<T, A> {

    public enum LoadableResourceEvents implements IResourceEvents {
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

    private static final long serialVersionUID = 5650544346961437168L;

    private Date loadStart;
    private Date loadEnd;

    public LoadableResource(T value) {
        super(value);
    }

    @Override
    public void onLoading() {
        this.loadStart = new Date();
        this.emit(LoadableResourceEvents.LOADING);
    }

    @Override
    public void onLoaded() {
        this.loadEnd = new Date();
        this.emit(LoadableResourceEvents.LOADED);
    }

    @Override
    public Date getLoadStart() {
        return this.loadStart;
    }

    @Override
    public Date getLoadEnd() {
        return this.loadEnd;
    }
}
