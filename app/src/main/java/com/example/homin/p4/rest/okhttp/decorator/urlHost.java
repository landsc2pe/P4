package com.example.homin.p4.rest.okhttp.decorator;

/**
 * Created by HOMIN on 2016-11-26.
 **/
public class UrlHost extends UrlDecorator {
    private UrlBase urlBase;
    private String host;


    public UrlHost(UrlBase urlBase, String host) {
        this.urlBase = urlBase;
        this.host = host;
    }


    @Override
    public String getUrl() {
        return urlBase.getUrl() + host;
    }
}
