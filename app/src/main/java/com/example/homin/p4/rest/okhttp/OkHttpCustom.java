package com.example.homin.p4.rest.okhttp;

/**
 * Created by HOMIN on 2016-11-18.
 **/

public class OkHttpCustom {
    private String fileName, language, getHtmlUrl, postHtmlUrl;

    public OkHttpCustom(String getHtmlUrl, String postHtmlUrl) {
//        this.fileName = fileName;
//        this.language = language;
        this.postHtmlUrl = postHtmlUrl;
        this.getHtmlUrl = getHtmlUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGetHtmlUrl() {
        return getHtmlUrl;
    }

    public void setGetHtmlUrl(String getHtmlUrl) {
        this.getHtmlUrl = getHtmlUrl;
    }

    public String getPostHtmlUrl() {
        return postHtmlUrl;
    }

    public void setPostHtmlUrl(String postHtmlUrl) {
        this.postHtmlUrl = postHtmlUrl;
    }
}
