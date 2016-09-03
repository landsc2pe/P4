package com.example.homin.p4.rest.tutorial.okhttp_singleton;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by jayjay on 2016. 8. 20..
 */
public class OkhttpTest {
    public static void test() {
        OkHttpClient client = OkhttpProvider1.getInstance().getOkHttpClient();
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host("api.naver.com")
                .addPathSegment("aaa")
                .addPathSegment("bbb")
                .build();

        Request request = new Request.Builder()
                .url("http://api.naver.com/aaa/bbb?&name2=bbb")
                .get()
                .header("name1", "aaaa")
                .header("bb", "value1")
                .build();
    }

    public static void test1() {
        // usage1
        OkhttpProvider1 okhttpProvider1 = OkhttpProvider1.getInstance();
        okhttpProvider1.method1();
        okhttpProvider1.method2();

        // usage2
        OkhttpProvider1.getInstance().method1();
        OkhttpProvider1.getInstance().method2();



        // usage1
        OkhttpProvider2 okhttpProvider2 = OkhttpProvider2.getInstance();
        okhttpProvider2.method1();
        okhttpProvider2.method2();

        // usage2
        OkhttpProvider2.getInstance().method1();
        OkhttpProvider2.getInstance().method2();
    }
}
