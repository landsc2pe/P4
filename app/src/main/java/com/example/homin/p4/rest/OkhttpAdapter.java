package com.example.homin.p4.rest;

<<<<<<< HEAD
import com.example.homin.p4.rest.interfaces.OkhttpListener;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by HOMIN on 2016-09-10.
 **/
public class OkHttpAdapter {


    private OkhttpListener okhttpItemListner;

    public OkHttpAdapter(Request request) {

        okhttpClient(request);
    }

    private void okhttpClient(Request request) {
        OkHttpClient client = OkHttpProvider.getInstance().getOkHttpClient();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                okhttpItemListner.onFail(call,e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                okhttpItemListner.onRes(call, response);
            }
        });

    }


    public void makeCall(OkhttpListener listener){
        okhttpItemListner = listener;
=======
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
>>>>>>> 1a066ba5700667bbd7bc01a7f4980fd53d416cf4
    }
}
