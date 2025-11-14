package com.equital.events;

import com.equital.listeners.ResourceListener;
import com.sun.istack.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ResourceEventEmitterImp<L extends ResourceListener<?>>
        implements ResourceEventEmitter<L> {

    private final Map<String, List<L>> listeners = new HashMap<>();

    @Override
    public <E extends ResourcesEvents> void suscribe(E event, @NotNull L listener) {
        List<L> _listeners = this.listeners.computeIfAbsent(
                event.getName(),
                k -> new ArrayList<>()
        );

        _listeners.add(listener);
    }

    @Override
    public <E extends ResourcesEvents> void unsuscribe(E event, @NotNull L listener) {
        List<L> _listeners = this.listeners.get(event.getName());

        if (_listeners == null) return;

        _listeners.remove(listener);
    }

    public <E extends ResourcesEvents> Iterable<L> listeners(E event) {
        if (this.listeners.containsKey(event.getName()))
            return this.listeners.get(event.getName());

        return new ArrayList<>();
    }
}
