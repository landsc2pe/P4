package com.example.homin.p4.rest.okhttp;

/**
 * Created by jayjay on 2016. 8. 20..
 */
public class OkhttpProvider2 {
    private OkhttpProvider2() {}

    // holder pattern
    private static class LazyHolder {
        private static final OkhttpProvider2 INSTANCE = new OkhttpProvider2();
    }

    public static OkhttpProvider2 getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void method1() {

    }

    public void method2() {

    }
}
