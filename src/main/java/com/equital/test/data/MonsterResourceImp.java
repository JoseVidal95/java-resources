package com.equital.test.data;

import com.equital.listeners.PropertyResourceListener;
import com.equital.models.ResourceApi;
import com.equital.resources.PropertyResourceImp;

public class MonsterResourceImp
        extends PropertyResourceImp<String, ResourceApi, PropertyResourceListener<String, ResourceApi>>
        implements MonsterResource {

    public MonsterResourceImp(String value) {
        super(value);
    }

}
