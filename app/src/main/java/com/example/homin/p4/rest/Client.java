package com.example.homin.p4.rest;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created by jayjay on 2016. 9. 10..
 */
public class Client {
    public static void main(String[] args) {

        OkhttpAdapter adapter = new OkhttpAdapter("https://api.github.com/users/octocat/repos");
        adapter.setOkhttp(new OkhttpAdapter.OkhttpInterface() {
            @Override
            public void onFailed(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) {
            }
        });

        OkhttpAdapter adapter1 = new OkhttpAdapter("https://api.github.com/users/octocat/repos");

        OkhttpAdapter adapter2 = new OkhttpAdapter("http://www.naver.com");


    }
}
