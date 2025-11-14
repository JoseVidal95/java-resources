package com.equital.models;

import com.equital.listeners.LoadableResourceListener;

public interface LoadableResource<L extends LoadableResourceListener<A>, A extends LoadableResourceApi>
        extends AsyncResource<L, A> {
}
