package com.example.homin.p4.rest.tutorial.okhttp_singleton;

import com.example.homin.p4.base.util.LogTag;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by jayjay on 2016. 8. 20..
 */
public class OkhttpProvider1 {
    static OkhttpProvider1 instance;
    private OkHttpClient okHttpClient;

    private OkhttpProvider1() {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        if(LogTag.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
            builder.addNetworkInterceptor(new StethoInterceptor());
        }

        okHttpClient = builder.build();
    }

    public static synchronized OkhttpProvider1 getInstance() {
        // DCL(Double Checked Locking)
        if(instance == null) {
            synchronized (OkhttpProvider1.class) {
                if(instance == null)
                    instance = new OkhttpProvider1();
            }
        }

        return instance;
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    @Deprecated
    public void method1() {

    }

    @Deprecated
    public void method2() {

    }
}
