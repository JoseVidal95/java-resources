/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equital.resources.models;

import com.utils.models.IConstantEnum;
import java.util.Map;

/**
 *
 * @author jvidal
 */
public interface IResourceData<K extends IConstantEnum, V> {

    Map<K, V> all();

    void set(Map<K, V> data);

    void set(K key, V value);

    V get(K key);
}
