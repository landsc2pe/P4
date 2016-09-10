package com.example.homin.p4.rest;

import okhttp3.*;

import java.io.IOException;

/**
 * Created by jayjay on 2016. 9. 10..
 */
public class OkhttpAdapter {
    private OkhttpInterface okHttpListener;
    String address;

    public OkhttpAdapter(String address) {
        this.address = address;

        okhttpClient(address);

    }

    private void okhttpClient(String address) {
        OkHttpClient client = RestOkhttpProvider.getInstance().getOkHttpClient();

        Request request = new Request.Builder()
                .url(address)
                .get()
                .build();


        client.newCall(request).enqueue(
                new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        okHttpListener.onFailed(call,e);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                    }
                }
        );
    }

    interface OkhttpInterface{
        void onFailed(Call call, IOException e);
        void onResponse(Call call, Response response);
    }

    public void setOkhttp(OkhttpInterface listener){
        okHttpListener = listener;
    }
}
