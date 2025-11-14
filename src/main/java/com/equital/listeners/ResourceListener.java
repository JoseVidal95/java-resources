package com.equital.listeners;

import com.equital.models.Resource;
import com.equital.models.ResourceApi;

public interface ResourceListener<A extends ResourceApi> {
    void update(Resource<A, ResourceListener<A>> resource);
}
