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
public interface ITableResource<T, R extends IPropertyResource<T, ?>, I, A extends ITableResourceApi<R, I>> extends ICollectionResource<T, R, I, A> {

    void add(I id, T item, IResourceData data);

    void add(Map<I, T> items, Map<I, IResourceData> data);

    void remove(I id);

    void remove(List<I> ids);

    void clear();
}
