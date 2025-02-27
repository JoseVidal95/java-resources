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
public interface IResourceData {

    <K, V> Map<K, V> all();

    <K, V> void set(K key, V value);

    <K, V> V get(K key);
}
