package com.equital.resources.impl;

import com.equital.resources.events.ResourceEventEmitterImp;
import com.equital.resources.events.ResourceListener;
import com.equital.resources.events.ResourcesEvents;
import com.equital.resources.models.Resource;
import com.equital.resources.models.ResourceApi;

public class ResourceImp<L extends ResourceListener<A>, A extends ResourceApi>
        extends ResourceEventEmitterImp<A, L>
        implements Resource<A, L> {

    private A api;

    @Override
    public <E extends ResourcesEvents> void attach(E event, L listener) {
        this.suscribe(event, listener);
    }

    @Override
    public <E extends ResourcesEvents> void deattach(E event, L listener) {
        this.unsuscribe(event, listener);
    }

    @Override
    public A api() {
        return api;
    }

    void setApi(A api) {
        this.api = api;
    }
}
