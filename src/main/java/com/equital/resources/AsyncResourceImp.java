package com.equital.resources;

import com.equital.events.LoadableResourceEvents;
import com.equital.listeners.LoadableResourceListener;
import com.equital.models.AsyncResource;
import com.equital.models.LoadableResourceApi;

import java.util.Date;

public class AsyncResourceImp<L extends LoadableResourceListener<A>, A extends LoadableResourceApi>
        extends ResourceImp<L, A> implements AsyncResource<L, A> {

    private boolean loading = false;
    private Date start;
    private Date end;

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
