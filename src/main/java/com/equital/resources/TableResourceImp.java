package com.equital.resources;

import com.equital.events.DisposableResourceEvents;
import com.equital.listeners.TableResourceListener;
import com.equital.models.PropertyResource;
import com.equital.models.ResourceApi;
import com.equital.models.TableResource;
import com.equital.models.TableResourceApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class TableResourceImp<T, R extends PropertyResource<T, ?, ?>, I, L extends TableResourceListener<R, I, A>,
                                              A extends TableResourceApi<R, I>>
        extends CollectionResourceImp<T, R, I, L, A> implements TableResource<T, R, I, L, A> {

    private final Map<I, R> table = new HashMap<>();

    @SuppressWarnings("unchecked")
    @Override
    public void add(I id, T value) {
        R resource = this.getChild(value);
        if (resource instanceof ResourceImp<?, ?>)
            ((ResourceImp<?, ResourceApi>) resource).setApi(this.api().create(id, resource));

        this.api().initialize(resource);
        this.table.put(id, resource);
        this.add(id);

        this.onAdd(id, resource);
    }

    @Override
    public void add(Map<I, T> values) {
        values.forEach(this::add);
    }

    @Override
    public R remove(I id) {
        R resource = this.get(id);

        this.api().dispose(id, resource);
        this.onDispose(id, resource);

        this.table.remove(id);
        this.removeId(id);

        this.onRemove(id, resource);

        return resource;
    }

    @Override
    public Iterable<R> remove(Iterable<I> ids) {
        List<R> resources = new ArrayList<>();
        ids.forEach(id -> resources.add(this.remove(id)));

        return resources;
    }

    @Override
    public void set(Map<I, T> values) {
        this.clear();
        this.add(values);
    }

    @Override
    public void clear() {
        this.table.clear();
        super.clear();
    }

    @Override
    public Iterable<R> list() {
        return new ArrayList<>(this.table.values());
    }

    @Override
    public Map<I, R> table() {
        return this.table;
    }

    @Override
    public Iterable<T> valueList() {
        List<T> values = new ArrayList<>();
        this.table.values().forEach(resource -> values.add(resource.get()));

        return values;
    }

    @Override
    public Map<I, T> valueTable() {
        final Map<I, T> values = new HashMap<>();
        this.table.forEach((id, resource) -> values.put(id, resource.get()));

        return values;
    }

    @Override
    public R get(I id) {
        return this.table.get(id);
    }

    @Override
    public boolean has(I id) {
        return this.table.containsKey(id);
    }

    protected void onDispose(I id, R resource) {
        this.listeners(DisposableResourceEvents.DISPOSED).forEach(listener -> listener.disposed(id, resource));
    }

}
