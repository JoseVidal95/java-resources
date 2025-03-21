/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equital.resources.models;

import java.util.List;

/**
 *
 * @author jvidal
 */
public interface ICollectionResource<T, A extends ICollectionResourceApi<T>>
        extends IPropertyResource<List<T>, A> {

    IPropertyResource builder(T item, IResourceData data);

    int getCount();

    T[] getValues();

    List<IPropertyResource> getList();

    void clear();

}
