package com.equital.events;

import com.equital.listeners.ResourceListener;

public interface ResourceEventEmitter<L extends ResourceListener<?>> {

    <E extends ResourcesEvents> void suscribe(E event, L listener);

    <E extends ResourcesEvents> void unsuscribe(E event, L listener);

    <E extends ResourcesEvents> Iterable<L> listeners(E event);
}
