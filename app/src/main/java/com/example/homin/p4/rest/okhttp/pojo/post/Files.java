
package com.example.homin.p4.rest.okhttp.pojo.post;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Files {

    @SerializedName("file1.txt")
    @Expose
    private File1Txt file1Txt;

    /**
     * 
     * @return
     *     The file1Txt
     */
    public File1Txt getFile1Txt() {
        return file1Txt;
    }

    /**
     * 
     * @param file1Txt
     *     The file1.txt
     */
    public void setFile1Txt(File1Txt file1Txt) {
        this.file1Txt = file1Txt;
    }

}
