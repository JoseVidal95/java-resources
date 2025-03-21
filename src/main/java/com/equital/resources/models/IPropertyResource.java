/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equital.resources.models;

/**
 *
 * @author jvidal
 */
public interface IPropertyResource<T, A extends IResourceApi> extends IResource<A> {

    T getValue();

    void onChange(T value);

    void changeData(T item, IResourceData data);
}
