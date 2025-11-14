package com.equital.resources;

import com.equital.events.ResourceEventEmitterImp;
import com.equital.events.ResourcesEvents;
import com.equital.exceptions.NullResourceApiException;
import com.equital.listeners.ResourceListener;
import com.equital.models.Resource;
import com.equital.models.ResourceApi;
import com.sun.istack.NotNull;

public abstract class ResourceImp<L extends ResourceListener<A>, A extends ResourceApi>
        extends ResourceEventEmitterImp<L>
        implements Resource<A, L> {

    private A api;

    @Override
    public <E extends ResourcesEvents> void attach(E event, @NotNull L listener) {
        this.suscribe(event, listener);
    }

    @Override
    public <E extends ResourcesEvents> void deattach(E event, @NotNull L listener) {
        this.unsuscribe(event, listener);
    }

    @Override
    public A api() {
        if (this.api == null) {
            throw new NullResourceApiException(this);
        }

        return api;
    }

    protected void setApi(@NotNull A api) {
        this.api = api;
    }
}
