package com.example.homin.p4.rest;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by HOMIN on 2016-08-27.
 */
public class OkHttpProvider {
    static OkHttpProvider instance;
    private OkHttpClient okHttpClient;

    private OkHttpProvider() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(interceptor);
        okHttpClient = builder.build();
    }

    public static synchronized OkHttpProvider getInstance() {

        if (instance == null) {
            synchronized (OkHttpProvider.class) {
                if (instance == null)
                    instance = new OkHttpProvider();
            }
        }
        return instance;
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }
}
