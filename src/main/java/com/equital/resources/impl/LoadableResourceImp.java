package com.equital.resources.impl;

import com.equital.resources.events.LoadableResourceListener;
import com.equital.resources.models.LoadableResource;
import com.equital.resources.models.LoadableResourceApi;

public class LoadableResourceImp<L extends LoadableResourceListener<A>, A extends LoadableResourceApi>
        extends AsyncResourceImp<L, A> implements LoadableResource<L, A> {
}
