/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equital.resources.impl;

import com.equital.resources.models.ICollectionResourceApi;
import com.equital.resources.models.IPropertyResource;
import com.equital.resources.models.IPropertyResourceBuilder;
import com.equital.resources.models.IResourceApi;
import com.equital.resources.models.IResourceData;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jvidal
 */
public abstract class TableResource<T, I, R extends IPropertyResource<T, ?>, A extends ICollectionResourceApi<T, I, R>>
        extends CollectionResource<T, R, I, A>
        implements ICollectionResourceApi {

    private final IPropertyResourceBuilder<T, R> builder;

    public TableResource(IPropertyResourceBuilder<T, R> builder) {
        super();
        this.builder = builder;
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

    @Override
    public void clear() {
        this.clearTable();
    }

    private void addOrUpdate(I id, T item, IResourceData data) {
        R child = this.get(id);

        if (child != null) {
            ((PropertyResource<T, IResourceApi>) child).changeData(item, data);
        } else {
            child = this.createChild(id, item, data);
            this.api.initialize(child);
        }

        this.addItem(id, child);
    }

    private R createChild(I id, T item, IResourceData data) {
        Resource<T, IResourceApi> resource = (Resource<T, IResourceApi>) this.builder.run(item);
        IResourceApi _api = this.api.createChildApi(id, (R) resource);
        resource.setApi(_api);

        if (data != null) {
            resource.setData(data);
        }

        return (R) resource;
    }

}
