package com.equital.resources.models;

import com.equital.constants.IResourceEvents;
import com.utils.events.IObserver;
import com.utils.logs.ILogService;

/**
 *
 * @author jvidal
 */
public interface IResource<T, A extends IResourceApi> {

    IResourceData data();

    T getValue();

    A getApi();

    void setLogService(ILogService service);

    void attach(IResourceEvents event, IObserver<T> observer);

    void deattach(IResourceEvents event, IObserver<T> observer);

}
