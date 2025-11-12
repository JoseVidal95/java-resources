package com.equital.resources.impl;

import com.equital.resources.events.LoadableResourceEvents;
import com.equital.resources.events.LoadableResourceListener;
import com.equital.resources.models.AsyncResource;
import com.equital.resources.models.LoadableResourceApi;
import com.equital.resources.models.Resource;

import java.util.Date;

public abstract class AsyncResourceImp<L extends LoadableResourceListener<A>, A extends LoadableResourceApi>
        extends ResourceDecorator<A, L> implements AsyncResource<L, A> {

    private boolean loading = false;
    private Date start;
    private Date end;

    public AsyncResourceImp(Resource<A, L> resource) {
        super(resource);
    }

    @Override
    public boolean loading() {
        return this.loading;
    }

    @Override
    public Date start() {
        return this.start;
    }

    @Override
    public Date end() {
        return this.end;
    }

    @Override
    public void onLoading() {
        this.loading = true;
        this.start = new Date();

        this.listeners(LoadableResourceEvents.LOADING).forEach(LoadableResourceListener::loading);
    }

    @Override
    public void onLoaded() {
        this.loading = false;
        this.end = new Date();

        this.listeners(LoadableResourceEvents.LOADED).forEach(LoadableResourceListener::loaded);
    }
}
