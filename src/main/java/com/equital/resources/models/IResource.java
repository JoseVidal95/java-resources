package com.equital.resources.models;

import com.equital.resources.constants.models.IResourceEvents;
import com.utils.events.models.IObserver;

/**
 *
 * @author jvidal
 */
public interface IResource<A extends IResourceApi> {

    IResourceData data();

    A getApi();

    void setApi(A api);

    void attach(IResourceEvents event, IObserver observer);

    void deattach(IResourceEvents event, IObserver observer);

}
