
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
    "id",
    "updated",
    "category",
    "title",
    "content",
    "link",
    "gsx$date",
    "gsx$service",
    "gsx$ampm",
    "gsx$preacher",
    "gsx$title",
    "gsx$passage",
    "gsx$series"
})
public class Entry {

    @JsonProperty("id")
    private Id_ id;
    @JsonProperty("updated")
    private Updated_ updated;
    @JsonProperty("category")
    private List<Category_> category = null;
    @JsonProperty("title")
    private Title_ title;
    @JsonProperty("content")
    private Content content;
    @JsonProperty("link")
    private List<Link_> link = null;
    @JsonProperty("gsx$date")
    private Gsx$date gsx$date;
    @JsonProperty("gsx$service")
    private Gsx$service gsx$service;
    @JsonProperty("gsx$ampm")
    private Gsx$ampm gsx$ampm;
    @JsonProperty("gsx$preacher")
    private Gsx$preacher gsx$preacher;
    @JsonProperty("gsx$title")
    private Gsx$title gsx$title;
    @JsonProperty("gsx$passage")
    private Gsx$passage gsx$passage;
    @JsonProperty("gsx$series")
    private Gsx$series gsx$series;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Id_ getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Id_ id) {
        this.id = id;
    }

    @JsonProperty("updated")
    public Updated_ getUpdated() {
        return updated;
    }

    @JsonProperty("updated")
    public void setUpdated(Updated_ updated) {
        this.updated = updated;
    }

    @JsonProperty("category")
    public List<Category_> getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(List<Category_> category) {
        this.category = category;
    }

    @JsonProperty("title")
    public Title_ getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(Title_ title) {
        this.title = title;
    }

    @JsonProperty("content")
    public Content getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(Content content) {
        this.content = content;
    }

    @JsonProperty("link")
    public List<Link_> getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(List<Link_> link) {
        this.link = link;
    }

    @JsonProperty("gsx$date")
    public Gsx$date getGsx$date() {
        return gsx$date;
    }

    @JsonProperty("gsx$date")
    public void setGsx$date(Gsx$date gsx$date) {
        this.gsx$date = gsx$date;
    }

    @JsonProperty("gsx$service")
    public Gsx$service getGsx$service() {
        return gsx$service;
    }

    @JsonProperty("gsx$service")
    public void setGsx$service(Gsx$service gsx$service) {
        this.gsx$service = gsx$service;
    }

    @JsonProperty("gsx$ampm")
    public Gsx$ampm getGsx$ampm() {
        return gsx$ampm;
    }

    @JsonProperty("gsx$ampm")
    public void setGsx$ampm(Gsx$ampm gsx$ampm) {
        this.gsx$ampm = gsx$ampm;
    }

    @JsonProperty("gsx$preacher")
    public Gsx$preacher getGsx$preacher() {
        return gsx$preacher;
    }

    @JsonProperty("gsx$preacher")
    public void setGsx$preacher(Gsx$preacher gsx$preacher) {
        this.gsx$preacher = gsx$preacher;
    }

    @JsonProperty("gsx$title")
    public Gsx$title getGsx$title() {
        return gsx$title;
    }

    @JsonProperty("gsx$title")
    public void setGsx$title(Gsx$title gsx$title) {
        this.gsx$title = gsx$title;
    }

    @JsonProperty("gsx$passage")
    public Gsx$passage getGsx$passage() {
        return gsx$passage;
    }

    @JsonProperty("gsx$passage")
    public void setGsx$passage(Gsx$passage gsx$passage) {
        this.gsx$passage = gsx$passage;
    }

    @JsonProperty("gsx$series")
    public Gsx$series getGsx$series() {
        return gsx$series;
    }

    @JsonProperty("gsx$series")
    public void setGsx$series(Gsx$series gsx$series) {
        this.gsx$series = gsx$series;
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
