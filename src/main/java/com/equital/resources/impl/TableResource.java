/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equital.resources.impl;

import com.equital.resources.models.ICollectionResourceApi;
import com.equital.resources.models.IPropertyResource;
import com.equital.resources.models.IResourceApi;
import com.equital.resources.models.IResourceData;
import com.equital.resources.models.ITableResource;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jvidal
 */
public abstract class TableResource<T, I, A extends ICollectionResourceApi<T, I>>
        extends CollectionResource<T, I, A>
        implements ITableResource<T, I, A> {

    private static final long serialVersionUID = -7246341170759116694L;

    public TableResource() {
        super();
    }

    public TableResource(Map<I, T> items) {
        super();
        items.forEach((k, v) -> this.addOrUpdate(k, v, null));
    }

    public TableResource(A api) {
        super(api);
    }

    public TableResource(Map<I, T> items, A api) {
        super(api);
        items.forEach((k, v) -> this.addOrUpdate(k, v, null));
    }

    @Override
    public void add(I id, T item) {
        this.addOrUpdate(id, item, null);
    }

    @Override
    public void add(Map<I, T> items) {
        items.forEach((k, v) -> this.addOrUpdate(k, v, null));
    }

    @Override
    public void add(I id, T item, IResourceData data) {
        this.addOrUpdate(id, item, data);
    }

    @Override
    public void add(Map<I, T> items, Map<I, IResourceData> data) {
        items.forEach((k, v) -> this.addOrUpdate(k, v, data.get(k)));
    }

    @Override
    public void remove(I id) {
        this.removeItem(id);
    }

    @Override
    public void remove(List<I> ids) {
        ids.forEach(id -> this.removeItem(id));
    }

    private void addOrUpdate(I id, T item, IResourceData data) {
        IPropertyResource<T, ?> child = this.get(id);

        if (child != null) {
            ((PropertyResource<T, IResourceApi>) child).changeData(item, data);
        } else {
            child = this.createChild(id, item, data);
            this.api.initialize(child);
        }

        this.addItem(id, child);
    }

    private IPropertyResource<T, ?> createChild(I id, T item, IResourceData data) {
        Resource<T, IResourceApi> resource = (Resource<T, IResourceApi>) this.builder(item);
        IResourceApi _api = this.api.createChildApi(id, (IPropertyResource<T, ?>) resource);
        resource.setApi(_api);
        resource.setData(data);

        return (IPropertyResource<T, ?>) resource;
    }

}
