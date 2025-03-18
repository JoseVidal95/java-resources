/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equital.resources.impl;

import com.equital.constants.IResourceEvents;
import com.equital.resources.models.IResource;
import com.equital.resources.models.IResourceApi;
import com.equital.resources.models.IResourceData;
import com.utils.constants.ILogContextEnum;
import com.utils.constants.ILogSeverityEnum;
import com.utils.events.EventHost;
import com.utils.events.IObserver;
import com.utils.logs.ILogService;
import com.utils.logs.LogService;
import java.io.Serializable;

/**
 *
 * @author jvidal
 */
public abstract class Resource<T, A extends IResourceApi> extends EventHost<T> implements IResource<T, A>, Serializable {

    private static final long serialVersionUID = -824551858507602146L;

    protected T value;
    protected A api;
    protected IResourceData data;

    public Resource(T value) {
        this.value = value;
    }

    @Override
    public IResourceData data() {
        return this.data;
    }

    void setData(IResourceData data) {
        this.data = data;
    }

    @Override
    public A getApi() {
        return this.api;
    }

    void setApi(A api) {
        this.api = api;
    }

    @Override
    public T getValue() {
        return this.value;
    }

    @Override
    public void attach(IResourceEvents event, IObserver<T> observer) {
        this.suscribe(event.getValue(), observer);
    }

    @Override
    public void deattach(IResourceEvents event, IObserver<T> observer) {
        this.unsuscribe(event.getValue(), observer);
    }

    @Override
    public void setLogService(ILogService service) {
        this.logger = service;
    }

    protected void emit(IResourceEvents event) {
        super.emit(event.getValue(), this.value);
    }

    protected void log(ILogContextEnum context, String message) {
        this.log(context, message, LogService.LogSeverity.INFO);
    }

    protected void log(ILogContextEnum context, String message, ILogSeverityEnum severity) {
        if (this.logger != null) {
            this.logger.log(severity, context, message);
        }
    }
}
