package com.equital.resources.events;

import com.equital.resources.models.LoadableResourceApi;

public interface LoadableResourceListener<A extends LoadableResourceApi> extends ResourceListener<A> {
    void loading();

    void loaded();
}
