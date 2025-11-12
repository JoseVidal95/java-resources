package com.equital.resources.events;

import com.equital.resources.models.ResourceApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ResourceEventEmitterImp<A extends ResourceApi, L extends ResourceListener<A>>
        implements ResourceEventEmitter<A, L> {
    private final Map<String, List<L>> listeners = new HashMap<>();

    @Override
    public <E extends ResourcesEvents> void suscribe(E event, L listener) {
        List<L> _listeners = this.listeners.computeIfAbsent(
                event.getName(),
                k -> new ArrayList<>()
        );

        _listeners.add(listener);
    }

    @Override
    public <E extends ResourcesEvents> void unsuscribe(E event, L listener) {
        List<L> _listeners = this.listeners.get(event.getName());

        if (_listeners == null) return;

        _listeners.remove(listener);
    }

    public <E extends ResourcesEvents> Iterable<L> listeners(E event) {
        return this.listeners.get(event.getName());
    }
}
