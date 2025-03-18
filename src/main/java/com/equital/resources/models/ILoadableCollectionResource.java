/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equital.resources.models;

/**
 *
 * @author jvidal
 */
public interface ILoadableCollectionResource<T, R extends IPropertyResource<T, ?>, I, A extends ILoadableCollectionResourceApi<T, I, R>>
        extends ICollectionResource<T, R, I, A> {

}
