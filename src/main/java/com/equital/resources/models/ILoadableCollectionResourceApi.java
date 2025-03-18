/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equital.resources.models;

/**
 *
 * @author jvidal
 */
public interface ILoadableCollectionResourceApi<T, I, R extends IPropertyResource<T, ?>>
        extends ILoadableResourceApi, ICollectionResourceApi<T, I, R> {
}
