package com.equital.resources.models;

public interface TableResourceApi<R extends Resource<?, ?>, I>
        extends CollectionResourceApi<R, I> {

    ResourceApi create(I id, R child);

    void initialize(R child);

    void dispose(I id, R child);
    
}
