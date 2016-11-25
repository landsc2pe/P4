package com.example.homin.p4.rest.okhttp.decorator;

/**
 * Created by HOMIN on 2016-11-26.
 **/
public class UrlPathSegment extends UrlDecorator {
    private UrlBase urlBase;
    private String segment;


    public UrlPathSegment(UrlBase urlBase, String segment) {
        this.urlBase = urlBase;
        this.segment = segment;
    }


    @Override
    public String getUrl() {
        return urlBase.getUrl() + segment;
    }
}
