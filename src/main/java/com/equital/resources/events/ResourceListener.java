package com.equital.resources.events;

import com.equital.resources.models.Resource;
import com.equital.resources.models.ResourceApi;

public interface ResourceListener<A extends ResourceApi> {
    void update(Resource<A, ResourceListener<A>> resource);
}
