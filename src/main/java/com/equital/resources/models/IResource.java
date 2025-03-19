package com.equital.resources.models;

import com.equital.resources.constants.models.IResourceEvents;
import com.utils.events.models.IObserver;
import com.utils.logs.models.ILogService;

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
