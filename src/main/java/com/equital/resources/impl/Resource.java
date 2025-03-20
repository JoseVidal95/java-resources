/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equital.resources.impl;

import com.equital.resources.constants.LogContextResource;
import com.equital.resources.constants.models.IResourceEvents;
import com.equital.resources.models.IResource;
import com.equital.resources.models.IResourceApi;
import com.equital.resources.models.IResourceData;
import com.utils.events.EventHost;
import com.utils.events.models.IObserver;
import com.utils.logs.LogService;
import com.utils.logs.models.ILogContextEnum;
import com.utils.logs.models.ILogService;
import com.utils.logs.models.ILogSeverityEnum;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author jvidal
 */
public abstract class Resource<T, A extends IResourceApi> extends EventHost<T> implements IResource<T, A>, Serializable {

    private static final long serialVersionUID = -824551858507602146L;

    private IResourceData data;
    private final Date created;
    protected A api;
    protected T value;

    public Resource(T value) {
        this.value = value;
        this.created = new Date();
    }

    public Resource(T value, IResourceData data) {
        this(value);
        this.data = data;
    }

    public Resource(T value, A api) {
        this(value);
        this.api = api;
    }

    public Resource(T value, A api, IResourceData data) {
        this(value, data);
        this.api = api;
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

    protected void setValue(T value) {
        this.value = value;
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
        this.log(event.getValue() + ": " + this.value);
    }

    protected void log(String message) {
        this.log(LogContextResource.RESOURCE, message, LogService.LogSeverity.INFO);
    }

    protected void log(ILogContextEnum context, String message, ILogSeverityEnum severity) {
        if (this.logger != null) {
            this.logger.log(severity, context, message);
        }
    }
}
