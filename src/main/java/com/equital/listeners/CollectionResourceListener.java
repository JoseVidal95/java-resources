package com.equital.listeners;

import com.equital.models.CollectionResourceApi;
import com.equital.models.Resource;

public interface CollectionResourceListener<R extends Resource<?, ?>, I, A extends CollectionResourceApi<R, I>>
        extends PropertyResourceListener<Iterable<I>, A> {

    void add(I id, R child);

    void removed(I id, R child);

}
