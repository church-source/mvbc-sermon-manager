
package org.churchsource.sermon.media.wp;

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
    "thumbnail",
    "medium",
    "medium_large",
    "large",
    "sermon_small",
    "sermon_medium",
    "sermon_wide",
    "featured-blog-large",
    "featured-blog-small",
    "featured-service",
    "featured-recent-work",
    "detail",
    "full"
})
public class Sizes {

    @JsonProperty("thumbnail")
    private Thumbnail thumbnail;
    @JsonProperty("medium")
    private Medium medium;
    @JsonProperty("medium_large")
    private MediumLarge mediumLarge;
    @JsonProperty("large")
    private Large large;
    @JsonProperty("sermon_small")
    private SermonSmall sermonSmall;
    @JsonProperty("sermon_medium")
    private SermonMedium sermonMedium;
    @JsonProperty("sermon_wide")
    private SermonWide sermonWide;
    @JsonProperty("featured-blog-large")
    private FeaturedBlogLarge featuredBlogLarge;
    @JsonProperty("featured-blog-small")
    private FeaturedBlogSmall featuredBlogSmall;
    @JsonProperty("featured-service")
    private FeaturedService featuredService;
    @JsonProperty("featured-recent-work")
    private FeaturedRecentWork featuredRecentWork;
    @JsonProperty("detail")
    private Detail detail;
    @JsonProperty("full")
    private Full full;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("thumbnail")
    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    @JsonProperty("thumbnail")
    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    @JsonProperty("medium")
    public Medium getMedium() {
        return medium;
    }

    @JsonProperty("medium")
    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    @JsonProperty("medium_large")
    public MediumLarge getMediumLarge() {
        return mediumLarge;
    }

    @JsonProperty("medium_large")
    public void setMediumLarge(MediumLarge mediumLarge) {
        this.mediumLarge = mediumLarge;
    }

    @JsonProperty("large")
    public Large getLarge() {
        return large;
    }

    @JsonProperty("large")
    public void setLarge(Large large) {
        this.large = large;
    }

    @JsonProperty("sermon_small")
    public SermonSmall getSermonSmall() {
        return sermonSmall;
    }

    @JsonProperty("sermon_small")
    public void setSermonSmall(SermonSmall sermonSmall) {
        this.sermonSmall = sermonSmall;
    }

    @JsonProperty("sermon_medium")
    public SermonMedium getSermonMedium() {
        return sermonMedium;
    }

    @JsonProperty("sermon_medium")
    public void setSermonMedium(SermonMedium sermonMedium) {
        this.sermonMedium = sermonMedium;
    }

    @JsonProperty("sermon_wide")
    public SermonWide getSermonWide() {
        return sermonWide;
    }

    @JsonProperty("sermon_wide")
    public void setSermonWide(SermonWide sermonWide) {
        this.sermonWide = sermonWide;
    }

    @JsonProperty("featured-blog-large")
    public FeaturedBlogLarge getFeaturedBlogLarge() {
        return featuredBlogLarge;
    }

    @JsonProperty("featured-blog-large")
    public void setFeaturedBlogLarge(FeaturedBlogLarge featuredBlogLarge) {
        this.featuredBlogLarge = featuredBlogLarge;
    }

    @JsonProperty("featured-blog-small")
    public FeaturedBlogSmall getFeaturedBlogSmall() {
        return featuredBlogSmall;
    }

    @JsonProperty("featured-blog-small")
    public void setFeaturedBlogSmall(FeaturedBlogSmall featuredBlogSmall) {
        this.featuredBlogSmall = featuredBlogSmall;
    }

    @JsonProperty("featured-service")
    public FeaturedService getFeaturedService() {
        return featuredService;
    }

    @JsonProperty("featured-service")
    public void setFeaturedService(FeaturedService featuredService) {
        this.featuredService = featuredService;
    }

    @JsonProperty("featured-recent-work")
    public FeaturedRecentWork getFeaturedRecentWork() {
        return featuredRecentWork;
    }

    @JsonProperty("featured-recent-work")
    public void setFeaturedRecentWork(FeaturedRecentWork featuredRecentWork) {
        this.featuredRecentWork = featuredRecentWork;
    }

    @JsonProperty("detail")
    public Detail getDetail() {
        return detail;
    }

    @JsonProperty("detail")
    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    @JsonProperty("full")
    public Full getFull() {
        return full;
    }

    @JsonProperty("full")
    public void setFull(Full full) {
        this.full = full;
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
