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
public interface ITableResource<T, I, A extends ITableResourceApi<T, I>>
        extends ICollectionResource<T, A> {

    boolean has(I id);

    void add(I id, T item);

    void add(Map<I, T> items);

    void add(I id, T item, IResourceData data);

    boolean remove(I... ids);

    IPropertyResource get(I id);

    Map<I, IPropertyResource> getTable();

    List<I> getIds();
}
