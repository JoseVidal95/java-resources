/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equital.resources.impl;

import com.equital.resources.models.ILoadableCollectionResourceApi;
import com.equital.resources.models.ILoadableResource;
import com.equital.resources.models.IPropertyResource;
import com.equital.resources.models.IPropertyResourceBuilder;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jvidal
 */
public abstract class LoadableTableResource<T, I, R extends IPropertyResource<T, ?>, A extends ILoadableCollectionResourceApi<T, I, R>>
        extends TableResource<T, I, R, A>
        implements ILoadableResource<List<T>, A> {

    private Date loadStart;
    private Date loadEnd;

    public LoadableTableResource(IPropertyResourceBuilder<T, R> builder) {
        super(builder);
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
