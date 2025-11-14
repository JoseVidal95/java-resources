package com.equital.test.data;

import com.equital.listeners.ListResourceListener;
import com.equital.models.ResourceApi;
import com.equital.resources.ListResourceImp;

public class IntegerListResource
        extends ListResourceImp<Integer, ListResourceListener<Integer, ResourceApi>, ResourceApi> {

    public IntegerListResource(Iterable<Integer> values) {
        super(values);
        this.setApi(new ResourceApi() {
        });
    }
    
}
