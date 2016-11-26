
package com.example.homin.p4.rest.okhttp.pojo.post.ex1;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class FileCreationBody {

    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("public")
    @Expose
    private boolean _public;
    @SerializedName("files")
    @Expose
    private List<File> files = new ArrayList<File>();

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The _public
     */
    public boolean isPublic() {
        return _public;
    }

    /**
     * 
     * @param _public
     *     The public
     */
    public void setPublic(boolean _public) {
        this._public = _public;
    }

    /**
     * 
     * @return
     *     The files
     */
    public List<File> getFiles() {
        return files;
    }

    /**
     * 
     * @param files
     *     The files
     */
    public void setFiles(List<File> files) {
        this.files = files;
    }

}
