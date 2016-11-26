package com.example.homin.p4.rest.okhttp.decorator;

/**
 * Created by HOMIN on 2016-11-26.
 **/
public class UrlScheme extends UrlDecorator {
    private UrlBase urlBase;
    private String scheme;


    public UrlScheme(UrlBase urlBase, String scheme) {
        this.urlBase = urlBase;
        this.scheme = scheme;
    }


    @Override
    public String getUrl() {
        return urlBase.getUrl() + scheme;
    }
}
