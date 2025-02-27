/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equital.resources.models;

import java.util.Map;

/**
 *
 * @author jvidal
 */
public interface IPropertyResource<T, Api> extends IResource<T, Api> {

    void onChange(T value);

    <K, V> void changeData(Map<K, V> data);
}
