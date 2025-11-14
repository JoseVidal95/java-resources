package com.equital.test.data;

import com.equital.listeners.PropertyResourceListener;
import com.equital.models.ResourceApi;
import com.equital.resources.PropertyResourceImp;

public class IntegerPropertyResource
        extends PropertyResourceImp<Integer, ResourceApi, PropertyResourceListener<Integer, ResourceApi>> {

    public IntegerPropertyResource(int value) {
        super(value);
        this.setApi(new ResourceApi() {
        });
    }

}
