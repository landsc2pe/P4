package com.example.homin.p4.rest.okhttp.decorator;

/**
 * Created by HOMIN on 2016-11-26.
 **/

public class UrlBase {
    private String url;

    public UrlBase() {
        this.url = "";
    }

    public String getUrl(){
        return url;
    }



    //scheme
    public String getHttp() {
        return "http:/";
    }

    public String getHttps() {
        return "https:/";
    }



    //host
    public String getGithubHost(){
        return "/api.github.com";
    }



    //segment
    public String getSegmentUser(){
        return "/users";
    }

    public String getSegmentGists(){
        return "/gists";
    }
}
