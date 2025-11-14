package com.equital.resources;

import com.equital.listeners.AsyncTableResourceListener;
import com.equital.models.AsyncTableResource;
import com.equital.models.AsyncTableResourceApi;
import com.equital.models.LoadableResource;
import com.equital.models.PropertyResource;

import java.util.Date;

public abstract class AsyncTableResourceImp<T, R extends PropertyResource<T, ?, ?>, I, L extends AsyncTableResourceListener<R, I, A>,
                                                   A extends AsyncTableResourceApi<R, I>> extends TableResourceImp<T, R, I, L, A>
        implements AsyncTableResource<T, R, I, L, A> {

    private final LoadableResource<L, A> loadable;

    public AsyncTableResourceImp() {
        this.loadable = new LoadableResourceImp<>();
    }

    @Override
    public boolean loading() {
        return this.loadable.loading();
    }

    @Override
    public Date start() {
        return this.loadable.start();
    }

    @Override
    public Date end() {
        return this.loadable.end();
    }

    @Override
    public void onLoading() {
        this.loadable.onLoading();
    }

    @Override
    public void onLoaded() {
        this.loadable.onLoaded();
    }
}
