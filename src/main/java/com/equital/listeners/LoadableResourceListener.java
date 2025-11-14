package com.equital.listeners;

import com.equital.models.LoadableResourceApi;

public interface LoadableResourceListener<A extends LoadableResourceApi> extends ResourceListener<A> {

    void loading();

    void loaded();
    
}
