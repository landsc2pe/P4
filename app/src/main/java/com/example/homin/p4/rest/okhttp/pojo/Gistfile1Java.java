
package com.example.homin.p4.rest.okhttp.pojo;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Gistfile1Java {

    @SerializedName("filename")
    @Expose
    private String filename;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("raw_url")
    @Expose
    private String rawUrl;
    @SerializedName("size")
    @Expose
    private int size;

    /**
     * 
     * @return
     *     The filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * 
     * @param filename
     *     The filename
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * 
     * @param language
     *     The language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * 
     * @return
     *     The rawUrl
     */
    public String getRawUrl() {
        return rawUrl;
    }

    /**
     * 
     * @param rawUrl
     *     The raw_url
     */
    public void setRawUrl(String rawUrl) {
        this.rawUrl = rawUrl;
    }

    /**
     * 
     * @return
     *     The size
     */
    public int getSize() {
        return size;
    }

    /**
     * 
     * @param size
     *     The size
     */
    public void setSize(int size) {
        this.size = size;
    }

}
