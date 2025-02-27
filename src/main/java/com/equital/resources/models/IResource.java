package com.equital.resources.models;

import com.utils.events.IObserver;

/**
 *
 * @author jvidal
 */
public interface IResource<T, A> {

    IResourceData data();

    T getValue();

    A getApi();

    void attach(String event, IObserver<T> observer);

    void deattach(String event, IObserver<T> observer);
}
