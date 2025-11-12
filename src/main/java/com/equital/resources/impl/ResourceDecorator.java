package com.equital.resources.impl;

import com.equital.resources.events.ResourceEventEmitter;
import com.equital.resources.events.ResourceListener;
import com.equital.resources.events.ResourcesEvents;
import com.equital.resources.models.Resource;
import com.equital.resources.models.ResourceApi;

public abstract class ResourceDecorator<A extends ResourceApi, L extends ResourceListener<A>> implements Resource<A, L> {
    private final Resource<A, L> resource;

    public ResourceDecorator(Resource<A, L> resource) {
        this.resource = resource;
    }

    @Override
    public A api() {
        return this.resource.api();
    }

    @Override
    public <E extends ResourcesEvents> void attach(E event, L listener) {
        this.resource.attach(event, listener);
    }

    @Override
    public <E extends ResourcesEvents> void deattach(E event, L listener) {
        this.resource.deattach(event, listener);
    }

    @SuppressWarnings("unchecked")
    protected <E extends ResourcesEvents> Iterable<L> listeners(E event) {
        return ((ResourceEventEmitter<A, L>) this.resource).listeners(event);
    }
}
