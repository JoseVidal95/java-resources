/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equital.resources.impl;

import com.equital.resources.models.ICollectionResourceApi;
import com.equital.resources.models.IListResource;
import com.equital.resources.models.IPropertyResource;
import com.equital.resources.models.IResourceApi;
import com.equital.resources.models.IResourceData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author jvidal
 */
public abstract class ListResource<T, A extends ICollectionResourceApi<T>> extends CollectionResource<T, A> implements IListResource<T, A> {

    private static final long serialVersionUID = 4651425862118049960L;
    private final List<IPropertyResource> resources;

    public ListResource() {
        super();
        this.resources = new ArrayList();
    }

    public ListResource(T... items) {
        this();
        this.add(items);
    }

    @Override
    public boolean has(T item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<IPropertyResource> getList() {
        return Collections.unmodifiableList(this.resources);
    }

    @Override
    public void push(T... items) {
        this.add(items);
    }

    @Override
    public void push(T item) {
        this.add(item, null);
    }

    @Override
    public void push(T item, IResourceData data) {
        this.add(item, data);
    }

    @Override
    public void pop() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void shift() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void unshift(T... item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public IPropertyResource<T, ? extends IResourceApi> get(int index) {
        if (index < 0 || index > this.getCount() - 1) {
            throw new IndexOutOfBoundsException();
        }

        return this.resources.get(index);
    }

    @Override
    public boolean remove(T... items) {
        boolean removed = false;

        for (T item : items) {
            removed = removed || this.removeItem(item);
        }

        return removed;
    }

    private void add(T... items) {
        for (T item : items) {
            this.add(item, null);
        }
    }

    private void add(T item, IResourceData data) {
        IPropertyResource<T, ? extends IResourceApi> resource = this.createChild(item, data);

        this.resources.add(resource);
        this.addItem(resource);
    }
}
