/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equital.resources.impl;

import com.equital.resources.models.IPropertyResource;
import com.equital.resources.models.IResourceApi;
import com.equital.resources.models.IResourceData;
import com.equital.resources.models.ITableResource;
import com.equital.resources.models.ITableResourceApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jvidal
 */
public abstract class TableResource<T, I, A extends ITableResourceApi<T, I>>
        extends CollectionResource<T, A>
        implements ITableResource<T, I, A> {

    private static final long serialVersionUID = -7246341170759116694L;
    private final Map<I, IPropertyResource> table;

    public TableResource() {
        super();
        this.table = new HashMap();
    }

    public TableResource(Map<I, T> items) {
        this();
        items.forEach((k, v) -> this.addOrUpdate(k, v, null));
    }

    @Override
    public boolean has(I id) {
        return this.table.containsKey(id);
    }

    @Override
    public IPropertyResource get(I id) {
        return this.table.get(id);
    }

    @Override
    public List<IPropertyResource> getList() {
        List<IPropertyResource> resources = new ArrayList();
        resources.addAll(this.table.values());

        return Collections.unmodifiableList(resources);
    }

    @Override
    public List<I> getIds() {
        I[] ids = (I[]) this.table.keySet().toArray();
        return Collections.unmodifiableList(Arrays.asList(ids));
    }

    @Override
    public Map<I, IPropertyResource> getTable() {
        return Collections.unmodifiableMap(this.table);
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
    public boolean remove(I... ids) {
        boolean removed = false;

        for (I id : ids) {
            IPropertyResource<T, ?> resource = this.get(id);

            if (resource == null) {
                removed = false;
            } else {
                removed = removed || this.removeItem(resource.getValue());
                this.table.remove(id);
            }
        }

        return removed;
    }

    @Override
    public void clear() {
        this.table.clear();
        super.clear();
    }

    private void addOrUpdate(I id, T item, IResourceData data) {
        IPropertyResource child = this.get(id);

        if (child != null) {
            child.changeData(item, data);
        } else {
            child = this.createChild(id, item, data);
            this.api.initialize(child);
        }

        this.table.put(id, child);
        this.addItem(child);
    }

    private IPropertyResource<T, ? extends IResourceApi> createChild(I id, T item, IResourceData data) {
        IPropertyResource resource = this.createChild(item, data);

        IResourceApi _api = this.api.createChildApi(id, resource);
        resource.setApi(_api);

        return resource;
    }
}
