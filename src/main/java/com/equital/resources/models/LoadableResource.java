package com.equital.resources.models;

import com.equital.resources.events.LoadableResourceListener;

public interface LoadableResource<L extends LoadableResourceListener<A>, A extends LoadableResourceApi>
        extends AsyncResource<L, A> {
}
