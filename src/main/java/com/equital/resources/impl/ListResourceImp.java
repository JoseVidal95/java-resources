package com.equital.resources.impl;

import com.equital.resources.events.CollectionResourceEvents;
import com.equital.resources.events.ListResourceListener;
import com.equital.resources.events.ResourceEvents;
import com.equital.resources.models.ListResource;
import com.equital.resources.models.Resource;
import com.equital.resources.models.ResourceApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ListResourceImp<T, L extends ListResourceListener<T, A>, A extends ResourceApi>
        extends ResourceDecorator<A, L> implements ListResource<T, L, A> {
    private final List<T> list = new ArrayList<>();

    public ListResourceImp(Resource<A, L> resource) {
        super(resource);
    }

    public ListResourceImp(Resource<A, L> resource, Iterable<T> values) {
        super(resource);
        values.forEach(this::add);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public void add(T value) {
        this.list.add(value);
        this.onAdd(Collections.singletonList(value));
    }

    @Override
    public void add(Iterable<T> values) {
        values.forEach(this::add);
    }

    @Override
    public T remove(int index) {
        T item = this.list.get(index);
        if (item == null) return null;

        this.list.remove(index);
        this.onRemove(index, item);

        return item;
    }

    @Override
    public T first() {
        return this.list.get(0);
    }

    @Override
    public T last() {
        return this.list.get(this.size() - 1);
    }

    @Override
    public Iterable<T> get() {
        return this.list;
    }

    @Override
    public void clear() {
        this.list.clear();
    }

    protected void onChange() {
        this.listeners(ResourceEvents.UPDATE).forEach(listener -> listener.change(this.get()));
    }

    protected void onAdd(Iterable<T> items) {
        this.listeners(CollectionResourceEvents.ADD)
                .forEach(listener -> listener.add(items));
        this.onChange();
    }

    protected void onRemove(int index, T item) {
        this.listeners(CollectionResourceEvents.REMOVE)
                .forEach(listener -> listener.remove(Collections.singletonList(item)));
        this.onChange();
    }

}
