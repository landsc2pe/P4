
package com.example.homin.p4.rest.okhttp.pojo.post.ex1;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class File {

    @SerializedName("file_name")
    @Expose
    private String fileName;
    @SerializedName("content")
    @Expose
    private String content;

    public File(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
    }

    /**
     *
     * @return
     *     The fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     *
     * @param fileName
     *     The file_name
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     *
     * @return
     *     The content
     */
    public String getContent() {
        return content;
    }

    /**
     *
     * @param content
     *     The content
     */
    public void setContent(String content) {
        this.content = content;
    }

}
