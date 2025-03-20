/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equital.resources.impl;

import com.equital.resources.constants.models.IResourceEvents;
import com.equital.resources.models.ICollectionResource;
import com.equital.resources.models.ICollectionResourceApi;
import com.equital.resources.models.IPropertyResource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jvidal
 */
public abstract class CollectionResource<T, I, A extends ICollectionResourceApi<T, I>>
        extends PropertyResource<List<T>, A>
        implements ICollectionResource<T, I, A> {

    private static final long serialVersionUID = 356535485314928121L;

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

    private final Map<I, IPropertyResource<T, ?>> table;

    public CollectionResource() {
        super(new ArrayList());
        this.table = new HashMap();
    }

    public CollectionResource(A api) {
        super(new ArrayList(), api);
        this.table = new HashMap();
    }

    @Override
    public IPropertyResource<T, ?> get(I id) {
        return this.table.get(id);
    }

    @Override
    public boolean has(I id) {
        return this.table.containsKey(id);
    }

    @Override
    public List<IPropertyResource<T, ?>> getList() {
        return Collections.unmodifiableList(new ArrayList(this.table.values()));
    }

    @Override
    public Map<I, IPropertyResource<T, ?>> getTable() {
        return Collections.unmodifiableMap(this.table);
    }

    @Override
    public List<T> getValue() {
        final List<T> values = new ArrayList();

        for (Map.Entry<I, IPropertyResource<T, ?>> entry : this.table.entrySet()) {
            IPropertyResource<T, ?> resource = entry.getValue();
            values.add(resource.getValue());
        }

        return Collections.unmodifiableList(values);
    }

    @Override
    public Map<I, T> getValuesTable() {
        final Map<I, T> valuesTable = new HashMap();

        for (Map.Entry<I, IPropertyResource<T, ?>> entry : this.table.entrySet()) {
            I key = entry.getKey();
            IPropertyResource<T, ?> resource = entry.getValue();
            valuesTable.put(key, resource.getValue());
        }

        return Collections.unmodifiableMap(valuesTable);
    }

    @Override
    public void clear() {
        this.table.clear();
        this.value = new ArrayList();
        this.emit(CollectionResourceEvents.CLEAR);
    }

    protected void addItem(I id, IPropertyResource<T, ?> resource) {
        this.table.put(id, resource);
        this.value.add(resource.getValue());
        this.emit(CollectionResourceEvents.ADD);
    }

    protected boolean removeItem(I id) {
        IPropertyResource<T, ?> removed = this.table.remove(id);

        if (removed != null) {
            this.value.remove(removed.getValue());
            this.emit(CollectionResourceEvents.REMOVE);
        }

        return removed != null;
    }

}
