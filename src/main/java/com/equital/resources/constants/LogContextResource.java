/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.equital.resources.constants;

import com.utils.logs.models.ILogContextEnum;

/**
 *
 * @author jvidal
 */
public enum LogContextResource implements ILogContextEnum {
    RESOURCE("resource");

    private final String value;

    private LogContextResource(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
