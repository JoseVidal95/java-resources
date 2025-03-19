/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equital.resources.models;

/**
 *
 * @author jvidal
 */
public interface ICollectionResourceApi<T, I> extends IResourceApi {

    IResourceApi createChildApi(I id, IPropertyResource<T, ?> resource);

    void initialize(IPropertyResource<T, ?> resource);

    void disposeChildApi(I id, IPropertyResource<T, ?> resource);

    void disposeAll();
}
