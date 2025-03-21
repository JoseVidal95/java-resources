/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equital.resources.models;

/**
 *
 * @author jvidal
 */
public interface ITableResourceApi<T, I> extends ICollectionResourceApi<T> {

    IResourceApi createChildApi(I id, IPropertyResource<T, ? extends IResourceApi> resource);

    void initialize(IPropertyResource<T, ? extends IResourceApi> resource);

    void disposeChildApi(I id, IPropertyResource<T, ? extends IResourceApi> resource);
}
