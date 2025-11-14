package com.equital.resources;

import com.equital.listeners.LoadableResourceListener;
import com.equital.models.LoadableResource;
import com.equital.models.LoadableResourceApi;

public class LoadableResourceImp<L extends LoadableResourceListener<A>, A extends LoadableResourceApi>
        extends AsyncResourceImp<L, A> implements LoadableResource<L, A> {
}
