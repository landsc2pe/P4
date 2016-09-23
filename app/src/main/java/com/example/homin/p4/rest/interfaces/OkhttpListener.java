package com.example.homin.p4.rest.interfaces;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by HOMIN on 2016-09-10.
 **/
public interface OkhttpListener {
    void onFail(Call call, IOException io);
    void onRes(Call call, Response response);
}
