
package com.example.homin.p4.rest.okhttp.pojo.post;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class ChangeStatus {

    @SerializedName("total")
    @Expose
    private int total;
    @SerializedName("additions")
    @Expose
    private int additions;
    @SerializedName("deletions")
    @Expose
    private int deletions;

    /**
     * 
     * @return
     *     The total
     */
    public int getTotal() {
        return total;
    }

    /**
     * 
     * @param total
     *     The total
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * 
     * @return
     *     The additions
     */
    public int getAdditions() {
        return additions;
    }

    /**
     * 
     * @param additions
     *     The additions
     */
    public void setAdditions(int additions) {
        this.additions = additions;
    }

    /**
     * 
     * @return
     *     The deletions
     */
    public int getDeletions() {
        return deletions;
    }

    /**
     * 
     * @param deletions
     *     The deletions
     */
    public void setDeletions(int deletions) {
        this.deletions = deletions;
    }

}
