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
public abstract class Resource< A extends IResourceApi> extends EventHost implements IResource< A>, Serializable {

    private static final long serialVersionUID = -824551858507602146L;

    private IResourceData data;
    private final Date created;
    protected A api;

    public Resource() {
        this.created = new Date();
        this.data = new ResourceData();
    }

    @Override
    public IResourceData data() {
        return this.data;
    }

    @Override
    public A getApi() {
        return this.api;
    }

    @Override
    public void setApi(A api) {
        this.api = api;
    }

    @Override
    public void attach(IResourceEvents event, IObserver observer) {
        this.suscribe(event.getValue(), observer);
    }

    @Override
    public void deattach(IResourceEvents event, IObserver observer) {
        this.unsuscribe(event.getValue(), observer);
    }

    void setLogService(ILogService service) {
        this.logger = service;
    }

    protected <T> void emit(IResourceEvents event, T args) {
        super.emit(event.getValue(), args);
        this.log(event.getValue() + ": " + args);
    }

    protected void emit(IResourceEvents event) {
        super.emit(event.getValue());
        this.log(event.getValue());
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
