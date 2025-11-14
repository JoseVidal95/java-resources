package com.equital.resources;

import com.equital.events.CollectionResourceEvents;
import com.equital.listeners.CollectionResourceListener;
import com.equital.models.CollectionResource;
import com.equital.models.CollectionResourceApi;
import com.equital.models.PropertyResource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class CollectionResourceImp<T, R extends PropertyResource<T, ?, ?>, I, L extends CollectionResourceListener<R, I, A>,
                                                   A extends CollectionResourceApi<R, I>>
        extends PropertyResourceImp<Iterable<I>, A, L> implements CollectionResource<T, R, I, L, A> {

    public CollectionResourceImp() {
        super(new ArrayList<>());
    }

    @Override
    public int size() {
        Iterable<I> list = this.get();

        if (list instanceof Collection) {
            return ((Collection<I>) list).size();
        }

        int count = 0;
        for (I ignored : list) {
            count++;
        }

        return count;
    }

    protected void add(I id) {
        List<I> ids = (List<I>) this.get();
        ids.add(id);
    }

    protected void removeId(I id) {
        List<I> ids = (List<I>) this.get();
        ids.remove(id);
    }

    protected void clear() {
        this.set(new ArrayList<>());
    }

    protected abstract R getChild(T value);

    protected void onAdd(I id, R child) {
        this.listeners(CollectionResourceEvents.ADD)
                .forEach(listener -> listener.add(id, child));
        this.onChange();
    }

    protected void onRemove(I id, R child) {
        this.listeners(CollectionResourceEvents.REMOVE)
                .forEach(listener -> listener.removed(id, child));
        this.onChange();
    }

}
