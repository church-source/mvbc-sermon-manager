
package org.churchsource.sermon.mvbcuploaded.wp;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "taxonomy",
    "embeddable",
    "href"
})
public class WpTerm {

    @JsonProperty("taxonomy")
    private String taxonomy;
    @JsonProperty("embeddable")
    private Boolean embeddable;
    @JsonProperty("href")
    private String href;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("taxonomy")
    public String getTaxonomy() {
        return taxonomy;
    }

    @JsonProperty("taxonomy")
    public void setTaxonomy(String taxonomy) {
        this.taxonomy = taxonomy;
    }

    @JsonProperty("embeddable")
    public Boolean getEmbeddable() {
        return embeddable;
    }

    @JsonProperty("embeddable")
    public void setEmbeddable(Boolean embeddable) {
        this.embeddable = embeddable;
    }

    @JsonProperty("href")
    public String getHref() {
        return href;
    }

    @JsonProperty("href")
    public void setHref(String href) {
        this.href = href;
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
