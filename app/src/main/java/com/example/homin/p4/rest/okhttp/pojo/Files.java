
package com.example.homin.p4.rest.okhttp.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Files {

    @SerializedName("gistfile1.java")
    @Expose
    private Gistfile1Java gistfile1Java;

    /**
     *
     * @return
     *     The gistfile1Java
     */
    public Gistfile1Java getGistfile1Java() {
        return gistfile1Java;
    }

    /**
     *
     * @param gistfile1Java
     *     The gistfile1.java
     */
    public void setGistfile1Java(Gistfile1Java gistfile1Java) {
        this.gistfile1Java = gistfile1Java;
    }

}
