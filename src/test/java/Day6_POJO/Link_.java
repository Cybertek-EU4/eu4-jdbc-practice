
package Day6_POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Link_ {

    @SerializedName("rel")
    @Expose
    private String rel;
    @SerializedName("href")
    @Expose
    private String href;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Link_() {
    }

    /**
     * 
     * @param rel
     * @param href
     */
    public Link_(String rel, String href) {
        super();
        this.rel = rel;
        this.href = href;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}
