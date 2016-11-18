package com.example.homin.p4.rest.okhttp;

/**
 * Created by HOMIN on 2016-11-18.
 **/

public class OkHttpCustom {
    private String fileName, language, htmlUrl;

    public OkHttpCustom(String htmlUrl) {
//        this.fileName = fileName;
//        this.language = language;
        this.htmlUrl = htmlUrl;
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

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }
}
