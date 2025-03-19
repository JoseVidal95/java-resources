/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equital.resources.impl;

import com.equital.resources.models.IResourceData;
import com.utils.models.IConstantEnum;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jvidal
 */
public class ResourceData<K extends IConstantEnum, V> implements IResourceData<K, V>, Serializable {

    private static final long serialVersionUID = -4974357641153275463L;

    private final Map<K, V> data;

    public ResourceData() {
        this.data = new HashMap();
    }

    @Override
    public Map<K, V> all() {
        return Collections.unmodifiableMap(this.data);
    }

    @Override
    public void set(Map<K, V> data) {
        this.data.putAll(data);
    }

    @Override
    public void set(K key, V value) {
        this.data.put(key, value);
    }

    @Override
    public V get(K key) {
        return this.data.get(key);
    }

}
