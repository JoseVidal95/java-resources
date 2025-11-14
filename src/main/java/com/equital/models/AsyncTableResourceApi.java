package com.equital.models;

public interface AsyncTableResourceApi<R extends Resource<?, ?>, I>
        extends TableResourceApi<R, I>, LoadableResourceApi {
}
