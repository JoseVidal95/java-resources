package com.equital.resources.models;

import com.equital.resources.events.LoadableResourceListener;

import java.util.Date;

public interface AsyncResource<L extends LoadableResourceListener<?>, A extends ResourceApi> {

    boolean loading();

    Date start();

    Date end();

    void onLoading();

    void onLoaded();

}
