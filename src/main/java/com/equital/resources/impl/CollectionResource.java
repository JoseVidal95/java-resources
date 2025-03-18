/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equital.resources.impl;

import com.equital.constants.IResourceEvents;
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
public abstract class CollectionResource<T, R extends IPropertyResource<T, ?>, I, A extends ICollectionResourceApi<T, I, R>>
        extends PropertyResource<List<T>, A>
        implements ICollectionResource<T, R, I, A> {

    public enum CollectionResourceEvents implements IResourceEvents {
        ADD("add"),
        REMOVE("remove");

        private final String value;

        private CollectionResourceEvents(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    private final Map<I, R> table;

    public CollectionResource() {
        super(new ArrayList());
        this.table = new HashMap();
    }

    @Override
    public R get(I id) {
        return this.table.get(id);
    }

    @Override
    public boolean has(I id) {
        return this.table.containsKey(id);
    }

    @Override
    public List<R> getList() {
        return new ArrayList(this.table.values());
    }

    @Override
    public Map<I, R> getTable() {
        return Collections.unmodifiableMap(this.table);
    }

    @Override
    public List<T> getValues() {
        final List<T> values = new ArrayList();

        for (Map.Entry<I, R> entry : this.table.entrySet()) {
            R resource = entry.getValue();
            values.add(resource.getValue());
        }

        return values;
    }

    @Override
    public Map<I, T> getValuesTable() {
        final Map<I, T> valuesTable = new HashMap();

        for (Map.Entry<I, R> entry : this.table.entrySet()) {
            I key = entry.getKey();
            R resource = entry.getValue();
            valuesTable.put(key, resource.getValue());
        }

        return valuesTable;
    }

    protected void addItem(I id, R resource) {
        this.table.put(id, resource);
        this.emit(CollectionResourceEvents.ADD);
    }

    protected void clearTable() {
        this.table.clear();
    }

    protected boolean removeItem(I id) {
        boolean removed = this.table.remove(id) == null;

        if (removed) {
            this.emit(CollectionResourceEvents.REMOVE);
        }

        return removed;
    }

}
