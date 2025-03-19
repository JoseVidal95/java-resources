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
public interface ICollectionResource<T, I, A extends ICollectionResourceApi<T, I>>
        extends IPropertyResource<List<T>, A> {

    IPropertyResource<T, ?> builder(T item);

    IPropertyResource<T, ?> get(I id);

    boolean has(I id);

    List<IPropertyResource<T, ?>> getList();

    Map<I, IPropertyResource<T, ?>> getTable();

    List<T> getValues();

    Map<I, T> getValuesTable();

    void clear();

}
