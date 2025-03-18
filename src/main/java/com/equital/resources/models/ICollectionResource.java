/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equital.resources.models;

import java.util.List;
import java.util.Map;

/**
 *
 * @author jvidal
 */
public interface ICollectionResource<T, R extends IPropertyResource<T, ?>, I, A extends ICollectionResourceApi<T, I, R>>
        extends IPropertyResource<List<T>, A> {

    R get(I id);

    boolean has(I id);

    List<R> getList();

    Map<I, R> getTable();

    List<T> getValues();

    Map<I, T> getValuesTable();

    void add(I id, T item);

    void add(Map<I, T> items);

    void add(I id, T item, IResourceData data);

    void add(Map<I, T> items, Map<I, IResourceData> data);

    void remove(I id);

    void remove(List<I> ids);

    void clear();

}
