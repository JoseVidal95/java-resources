package com.equital.models;

import com.equital.listeners.TableResourceListener;

import java.util.Map;

public interface TableResource<T, R extends PropertyResource<T, ?, ?>, I, L extends TableResourceListener<R, I, A>,
                                      A extends TableResourceApi<R, I>>
        extends CollectionResource<T, R, I, L, A> {

    void add(I id, T value);

    void add(Map<I, T> values);

    R remove(I id);

    Iterable<R> remove(Iterable<I> ids);

    void set(Map<I, T> values);

    void clear();

}
