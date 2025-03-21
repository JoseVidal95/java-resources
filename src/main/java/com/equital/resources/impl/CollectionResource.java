/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equital.resources.impl;

import com.equital.resources.constants.models.IResourceEvents;
import com.equital.resources.models.ICollectionResource;
import com.equital.resources.models.ICollectionResourceApi;
import com.equital.resources.models.IPropertyResource;
import com.equital.resources.models.IResourceApi;
import com.equital.resources.models.IResourceData;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jvidal
 */
public abstract class CollectionResource<T, A extends ICollectionResourceApi<T>>
        extends PropertyResource<List<T>, A>
        implements ICollectionResource<T, A> {

    public enum CollectionResourceEvents implements IResourceEvents {
        ADD("add"),
        REMOVE("remove"),
        CLEAR("clear");

        private final String value;

        private CollectionResourceEvents(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    private static final long serialVersionUID = 356535485314928121L;

    public CollectionResource() {
        super(new ArrayList());
    }

    @Override
    public int getCount() {
        return this.value.size();
    }

    @Override
    public T[] getValues() {
        return (T[]) this.value.toArray();
    }

    @Override
    public void clear() {
        this.value = new ArrayList();
        this.emit(CollectionResourceEvents.CLEAR);
    }

    /**
     * This method is responsible only for adding a new value to the values
     * list. It does not initialize the resource
     *
     * @param resource
     */
    protected void addItem(IPropertyResource<T, ?> resource) {
        this.value.add(resource.getValue());
        this.emit(CollectionResourceEvents.ADD, resource.getValue());
    }

    protected boolean removeItem(T item) {
        boolean removed = this.value.remove(item);

        if (removed) {
            this.emit(CollectionResourceEvents.REMOVE, item);
        }

        return removed;
    }

    /**
     * This method is responsible for assigning API and Logger. It should always
     * be called in child classes for creating the basic resource.
     *
     * @param item The value item
     * @param data The data mappings for the value
     * @return A IPropertyResource initialized
     */
    protected IPropertyResource<T, ? extends IResourceApi> createChild(T item, IResourceData data) {
        IPropertyResource resource = this.builder(item, data);
        IResourceApi _api = this.api.createChildApi((IPropertyResource) resource);

        resource.setApi(_api);

        if (this.logger != null) {
            ((Resource) resource).setLogService(this.logger);
        }

        return resource;
    }
}
