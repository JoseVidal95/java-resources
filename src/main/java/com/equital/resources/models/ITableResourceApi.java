/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equital.resources.models;

/**
 *
 * @author jvidal
 */
public interface ITableResourceApi<R extends IPropertyResource, I> {

    <AX> AX createChildApi(I id, R resource);

    void initialize(R resource);

    void dispose(I id, R resource);

    void dispose();
}
