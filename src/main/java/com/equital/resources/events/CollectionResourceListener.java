package com.equital.resources.events;

import com.equital.resources.models.CollectionResourceApi;
import com.equital.resources.models.Resource;

public interface CollectionResourceListener<R extends Resource<?, ?>, I, A extends CollectionResourceApi<R, I>>
        extends PropertyResourceListener<Iterable<I>, A> {

    void add(I id, R child);

    void removed(I id, R child);

}
