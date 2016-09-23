package com.example.homin.p4.rest.interfaces;

import com.example.homin.p4.rest.OkHttpConcreteRequest;

import okhttp3.RequestBody;

/**
 * Created by HOMIN on 2016-09-21.
 **/

public interface OkHttpRequest {

    OkHttpConcreteRequest.OkHttpAssist webRequest(RequestBody body);

    OkHttpConcreteRequest.OkHttpAssist serverRequest(RequestBody body);

    OkHttpConcreteRequest.OkHttpAssist apiRequest(RequestBody body);
}
