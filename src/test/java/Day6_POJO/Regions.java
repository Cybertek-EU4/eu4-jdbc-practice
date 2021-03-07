
package Day6_POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Regions {

    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    @SerializedName("hasMore")
    @Expose
    private Boolean hasMore;
    @SerializedName("limit")
    @Expose
    private Integer limit;
    @SerializedName("offset")
    @Expose
    private Integer offset;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("links")
    @Expose
    private List<Link_> links = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Regions() {
    }

    /**
     * 
     * @param offset
     * @param hasMore
     * @param limit
     * @param count
     * @param links
     * @param items
     */
    public Regions(List<Item> items, Boolean hasMore, Integer limit, Integer offset, Integer count, List<Link_> links) {
        super();
        this.items = items;
        this.hasMore = hasMore;
        this.limit = limit;
        this.offset = offset;
        this.count = count;
        this.links = links;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Link_> getLinks() {
        return links;
    }

    public void setLinks(List<Link_> links) {
        this.links = links;
    }

}
