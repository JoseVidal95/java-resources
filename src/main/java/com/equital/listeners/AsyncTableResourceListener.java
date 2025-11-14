package com.equital.listeners;

import com.equital.models.AsyncTableResourceApi;
import com.equital.models.Resource;

public interface AsyncTableResourceListener<R extends Resource<?, ?>, I, A extends AsyncTableResourceApi<R, I>>
        extends TableResourceListener<R, I, A>, LoadableResourceListener<A> {
}
