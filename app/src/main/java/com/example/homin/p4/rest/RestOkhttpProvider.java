package com.example.homin.p4.rest;

import okhttp3.OkHttpClient;

/**
 * Created by HOMIN on 2016-08-27.
 */
public class RestOkhttpProvider {
    static RestOkhttpProvider instance;
    private OkHttpClient okHttpClient;

    private RestOkhttpProvider() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        okHttpClient = builder.build();
    }

    public static synchronized RestOkhttpProvider getInstance() {

        if (instance == null) {
            synchronized (RestOkhttpProvider.class) {
                if (instance == null)
                    instance = new RestOkhttpProvider();
            }
        }
        return instance;
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }
}
