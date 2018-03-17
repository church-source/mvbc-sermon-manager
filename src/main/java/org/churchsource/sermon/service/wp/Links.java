
package org.churchsource.sermon.service.wp;

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
    "self",
    "collection",
    "about",
    "wp:post_type",
    "curies"
})
public class Links {

    @JsonProperty("self")
    private List<Self> self = null;
    @JsonProperty("collection")
    private List<Collection> collection = null;
    @JsonProperty("about")
    private List<About> about = null;
    @JsonProperty("wp:post_type")
    private List<WpPostType> wpPostType = null;
    @JsonProperty("curies")
    private List<Cury> curies = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("self")
    public List<Self> getSelf() {
        return self;
    }

    @JsonProperty("self")
    public void setSelf(List<Self> self) {
        this.self = self;
    }

    @JsonProperty("collection")
    public List<Collection> getCollection() {
        return collection;
    }

    @JsonProperty("collection")
    public void setCollection(List<Collection> collection) {
        this.collection = collection;
    }

    @JsonProperty("about")
    public List<About> getAbout() {
        return about;
    }

    @JsonProperty("about")
    public void setAbout(List<About> about) {
        this.about = about;
    }

    @JsonProperty("wp:post_type")
    public List<WpPostType> getWpPostType() {
        return wpPostType;
    }

    @JsonProperty("wp:post_type")
    public void setWpPostType(List<WpPostType> wpPostType) {
        this.wpPostType = wpPostType;
    }

    @JsonProperty("curies")
    public List<Cury> getCuries() {
        return curies;
    }

    @JsonProperty("curies")
    public void setCuries(List<Cury> curies) {
        this.curies = curies;
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
