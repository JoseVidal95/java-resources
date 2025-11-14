package com.equital.models;

import com.equital.listeners.LoadableResourceListener;

import java.util.Date;

public interface AsyncResource<L extends LoadableResourceListener<A>, A extends LoadableResourceApi>
        extends Resource<A, L> {

    boolean loading();

    Date start();

    Date end();

    void onLoading();

    void onLoaded();

}
