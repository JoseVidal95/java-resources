/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equital.resources.impl;

import com.equital.resources.models.ILoadableCollectionResource;
import com.equital.resources.models.ILoadableCollectionResourceApi;
import java.util.Date;

/**
 *
 * @author jvidal
 */
public abstract class LoadableTableResource<T, I, A extends ILoadableCollectionResourceApi<T, I>>
        extends TableResource<T, I, A>
        implements ILoadableCollectionResource<T, I, A> {

    private static final long serialVersionUID = -2619628731880637705L;

    private Date loadStart;
    private Date loadEnd;

    public LoadableTableResource() {
        super();
    }

    public LoadableTableResource(A api) {
        super(api);
    }

    @Override
    public void onLoading() {
        this.loadStart = new Date();
        this.emit(LoadableResource.LoadableResourceEvents.LOADING);
    }

    @Override
    public void onLoaded() {
        this.loadEnd = new Date();
        this.emit(LoadableResource.LoadableResourceEvents.LOADED);
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
