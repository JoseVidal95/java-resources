package com.equital.resources.events;

import com.equital.resources.models.ResourceApi;

public interface ResourceEventEmitter<A extends ResourceApi, L extends ResourceListener<A>> {
    <E extends ResourcesEvents> void suscribe(E event, L listener);

    <E extends ResourcesEvents> void unsuscribe(E event, L listener);
}
