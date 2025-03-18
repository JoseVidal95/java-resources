/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equital.resources.models;

/**
 *
 * @author jvidal
 */
public interface ICollectionResourceApi<T, I, R extends IPropertyResource<T, ?>> extends IResourceApi {

    IResourceApi createChildApi(I id, R resource);

    void initialize(R resource);

    void disposeChildApi(I id, R resource);

    void disposeAll();
}
