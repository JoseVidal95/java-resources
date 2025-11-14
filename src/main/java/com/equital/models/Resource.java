package com.equital.models;

import com.equital.events.ResourcesEvents;
import com.equital.listeners.ResourceListener;

public interface Resource<A extends ResourceApi, L extends ResourceListener<A>> {

    A api();

    <E extends ResourcesEvents> void attach(E event, L listener);

    <E extends ResourcesEvents> void deattach(E event, L listener);

}
