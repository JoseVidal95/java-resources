package com.equital.models;

import com.equital.listeners.AsyncTableResourceListener;

public interface AsyncTableResource<T, R extends PropertyResource<T, ?, ?>, I, L extends AsyncTableResourceListener<R, I, A>,
                                           A extends AsyncTableResourceApi<R, I>>
        extends TableResource<T, R, I, L, A>, LoadableResource<L, A> {
}
