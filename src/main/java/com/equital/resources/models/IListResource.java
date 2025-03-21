/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equital.resources.models;

/**
 *
 * @author jvidal
 */
public interface IListResource<T, A extends ICollectionResourceApi<T>> extends ICollectionResource<T, A> {

    boolean has(T item);

    void push(T... item);

    void push(T item);

    void push(T item, IResourceData data);

    void pop();

    void shift();

    void unshift(T... item);

    IPropertyResource get(int index);

    boolean remove(T... items);

}
