package com.equital.resources.models;

import com.equital.resources.events.ResourceListener;
import com.equital.resources.events.ResourcesEvents;

public interface Resource<A extends ResourceApi, L extends ResourceListener<A>> {

    A api();

    <E extends ResourcesEvents> void attach(E event, L listener);

    <E extends ResourcesEvents> void deattach(E event, L listener);

}
