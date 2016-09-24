package com.example.homin.p4.rest;

import com.example.homin.p4.rest.interfaces.OkHttpRequest;

import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by HOMIN on 2016-09-21.
 *
 * 필요한 요청들을 모듈화 시켜서 교체하면서 사용 할 수 있다.....?
 **/

public class OkHttpConcreteRequest implements OkHttpRequest {
    @Override
    public OkHttpAssist webRequest(RequestBody body) {
        return new OkHttpAssist(RestAddress.webAdress, null);
    }

    @Override
    public OkHttpAssist serverRequest(RequestBody body) {
        return new OkHttpAssist(RestAddress.serverAdress, null);
    }

    @Override
    public OkHttpAssist apiRequest(RequestBody body) {
        return new OkHttpAssist("adress", null);
    }


    public class OkHttpAssist {

        private String address;
        private RequestBody body;

        public OkHttpAssist(String address, RequestBody body) {
            this.address = address;
            this.body = body;
        }

        public Request get() {
            return new Request.Builder()
                    .url(address)
                    .get()
                    .build();
        }

        public Request delete() {
            return new Request.Builder()
                    .url(address)
                    .delete()
                    .build();
        }

        public Request post() {
            if (body != null) {
                return new Request.Builder()
                        .url(address)
                        .post(body)
                        .build();
            } else {
                return null;
            }
        }

        public Request put() {
            if (body != null) {
                return new Request.Builder()
                        .url(address)
                        .put(body)
                        .build();
            } else {
                return null;
            }
        }
    }
}
