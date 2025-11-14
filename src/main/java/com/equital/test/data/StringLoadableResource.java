package com.equital.test.data;

import com.equital.listeners.LoadableResourceListener;
import com.equital.models.LoadableResourceApi;
import com.equital.resources.LoadableResourceImp;

public class StringLoadableResource
        extends LoadableResourceImp<LoadableResourceListener<LoadableResourceApi>, LoadableResourceApi> {

    public StringLoadableResource() {
        this.setApi(new LoadableResourceApi() {

            @Override
            public void load() {
            }

        });
    }

}
