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
public interface ILoadableCollectionResource<T, I, A extends ILoadableCollectionResourceApi<T, I>>
        extends ICollectionResource<T, I, A>, ILoadableResource<List<T>, A> {
}
