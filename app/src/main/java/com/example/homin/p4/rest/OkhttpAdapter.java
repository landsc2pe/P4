package com.example.homin.p4.rest;

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
public class OkhttpAdapter {
    private OkhttpListener okhttpItemListner;

    public OkhttpAdapter(Request request) {

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


    public void makeCall(OkhttpListener listener) {
        okhttpItemListner = listener;
    }
}
