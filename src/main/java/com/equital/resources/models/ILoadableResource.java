/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equital.resources.models;

import java.util.Date;

/**
 *
 * @author jvidal
 */
public interface ILoadableResource<T, A extends ILoadableResourceApi> extends IResource<T, A> {

    void onLoading();

    void onLoaded();

    Date getLoadStart();

    Date getLoadEnd();
}
