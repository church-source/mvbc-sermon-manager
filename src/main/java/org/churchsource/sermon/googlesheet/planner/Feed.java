
package org.churchsource.sermon.googlesheet.planner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "xmlns",
    "xmlns$openSearch",
    "xmlns$gsx",
    "id",
    "updated",
    "category",
    "title",
    "link",
    "author",
    "openSearch$totalResults",
    "openSearch$startIndex",
    "entry"
})
public class Feed {

    @JsonProperty("xmlns")
    private String xmlns;
    @JsonProperty("xmlns$openSearch")
    private String xmlns$openSearch;
    @JsonProperty("xmlns$gsx")
    private String xmlns$gsx;
    @JsonProperty("id")
    private Id id;
    @JsonProperty("updated")
    private Updated updated;
    @JsonProperty("category")
    private List<Category> category = null;
    @JsonProperty("title")
    private Title title;
    @JsonProperty("link")
    private List<Link> link = null;
    @JsonProperty("author")
    private List<Author> author = null;
    @JsonProperty("openSearch$totalResults")
    private OpenSearch$totalResults openSearch$totalResults;
    @JsonProperty("openSearch$startIndex")
    private OpenSearch$startIndex openSearch$startIndex;
    @JsonProperty("entry")
    private List<Entry> entry = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("xmlns")
    public String getXmlns() {
        return xmlns;
    }

    @JsonProperty("xmlns")
    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    @JsonProperty("xmlns$openSearch")
    public String getXmlns$openSearch() {
        return xmlns$openSearch;
    }

    @JsonProperty("xmlns$openSearch")
    public void setXmlns$openSearch(String xmlns$openSearch) {
        this.xmlns$openSearch = xmlns$openSearch;
    }

    @JsonProperty("xmlns$gsx")
    public String getXmlns$gsx() {
        return xmlns$gsx;
    }

    @JsonProperty("xmlns$gsx")
    public void setXmlns$gsx(String xmlns$gsx) {
        this.xmlns$gsx = xmlns$gsx;
    }

    @JsonProperty("id")
    public Id getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Id id) {
        this.id = id;
    }

    @JsonProperty("updated")
    public Updated getUpdated() {
        return updated;
    }

    @JsonProperty("updated")
    public void setUpdated(Updated updated) {
        this.updated = updated;
    }

    @JsonProperty("category")
    public List<Category> getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(List<Category> category) {
        this.category = category;
    }

    @JsonProperty("title")
    public Title getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(Title title) {
        this.title = title;
    }

    @JsonProperty("link")
    public List<Link> getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(List<Link> link) {
        this.link = link;
    }

    @JsonProperty("author")
    public List<Author> getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    @JsonProperty("openSearch$totalResults")
    public OpenSearch$totalResults getOpenSearch$totalResults() {
        return openSearch$totalResults;
    }

    @JsonProperty("openSearch$totalResults")
    public void setOpenSearch$totalResults(OpenSearch$totalResults openSearch$totalResults) {
        this.openSearch$totalResults = openSearch$totalResults;
    }

    @JsonProperty("openSearch$startIndex")
    public OpenSearch$startIndex getOpenSearch$startIndex() {
        return openSearch$startIndex;
    }

    @JsonProperty("openSearch$startIndex")
    public void setOpenSearch$startIndex(OpenSearch$startIndex openSearch$startIndex) {
        this.openSearch$startIndex = openSearch$startIndex;
    }

    @JsonProperty("entry")
    public List<Entry> getEntry() {
        return entry;
    }

    @JsonProperty("entry")
    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
