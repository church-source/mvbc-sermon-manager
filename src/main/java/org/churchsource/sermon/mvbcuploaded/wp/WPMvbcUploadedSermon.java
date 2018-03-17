
package org.churchsource.sermon.mvbcuploaded.wp;

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
    "date",
    "date_gmt",
    "guid",
    "modified",
    "modified_gmt",
    "slug",
    "status",
    "type",
    "link",
    "title",
    "featured_media",
    "comment_status",
    "ping_status",
    "template",
    "wpfc_preacher",
    "wpfc_sermon_series",
    "wpfc_sermon_topics",
    "wpfc_bible_book",
    "wpfc_service_type",
    "sermon_audio",
    "sermon_audio_duration",
    "_views",
    "bible_passage",
    "sermon_description",
    "sermon_video_embed",
    "sermon_video_url",
    "sermon_bulletin",
    "_featured_url",
    "sermon_date",
    "_sermon_date_auto",
    "_links"
})
public class WPMvbcUploadedSermon {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("date")
    private String date;
    @JsonProperty("date_gmt")
    private String dateGmt;
    @JsonProperty("guid")
    private Guid guid;
    @JsonProperty("modified")
    private String modified;
    @JsonProperty("modified_gmt")
    private String modifiedGmt;
    @JsonProperty("slug")
    private String slug;
    @JsonProperty("status")
    private String status;
    @JsonProperty("type")
    private String type;
    @JsonProperty("link")
    private String link;
    @JsonProperty("title")
    private Title title;
    @JsonProperty("featured_media")
    private Integer featuredMedia;
    @JsonProperty("comment_status")
    private String commentStatus;
    @JsonProperty("ping_status")
    private String pingStatus;
    @JsonProperty("template")
    private String template;
    @JsonProperty("wpfc_preacher")
    private List<Integer> wpfcPreacher = null;
    @JsonProperty("wpfc_sermon_series")
    private List<Object> wpfcSermonSeries = null;
    @JsonProperty("wpfc_sermon_topics")
    private List<Object> wpfcSermonTopics = null;
    @JsonProperty("wpfc_bible_book")
    private List<Integer> wpfcBibleBook = null;
    @JsonProperty("wpfc_service_type")
    private List<Integer> wpfcServiceType = null;
    @JsonProperty("sermon_audio")
    private String sermonAudio;
    @JsonProperty("sermon_audio_duration")
    private String sermonAudioDuration;
    @JsonProperty("_views")
    private String views;
    @JsonProperty("bible_passage")
    private String biblePassage;
    @JsonProperty("sermon_description")
    private String sermonDescription;
    @JsonProperty("sermon_video_embed")
    private String sermonVideoEmbed;
    @JsonProperty("sermon_video_url")
    private String sermonVideoUrl;
    @JsonProperty("sermon_bulletin")
    private String sermonBulletin;
    @JsonProperty("_featured_url")
    private String featuredUrl;
    @JsonProperty("sermon_date")
    private Integer sermonDate;
    @JsonProperty("_sermon_date_auto")
    private Boolean sermonDateAuto;
    @JsonProperty("_links")
    private Links links;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("date_gmt")
    public String getDateGmt() {
        return dateGmt;
    }

    @JsonProperty("date_gmt")
    public void setDateGmt(String dateGmt) {
        this.dateGmt = dateGmt;
    }

    @JsonProperty("guid")
    public Guid getGuid() {
        return guid;
    }

    @JsonProperty("guid")
    public void setGuid(Guid guid) {
        this.guid = guid;
    }

    @JsonProperty("modified")
    public String getModified() {
        return modified;
    }

    @JsonProperty("modified")
    public void setModified(String modified) {
        this.modified = modified;
    }

    @JsonProperty("modified_gmt")
    public String getModifiedGmt() {
        return modifiedGmt;
    }

    @JsonProperty("modified_gmt")
    public void setModifiedGmt(String modifiedGmt) {
        this.modifiedGmt = modifiedGmt;
    }

    @JsonProperty("slug")
    public String getSlug() {
        return slug;
    }

    @JsonProperty("slug")
    public void setSlug(String slug) {
        this.slug = slug;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    @JsonProperty("title")
    public Title getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(Title title) {
        this.title = title;
    }

    @JsonProperty("featured_media")
    public Integer getFeaturedMedia() {
        return featuredMedia;
    }

    @JsonProperty("featured_media")
    public void setFeaturedMedia(Integer featuredMedia) {
        this.featuredMedia = featuredMedia;
    }

    @JsonProperty("comment_status")
    public String getCommentStatus() {
        return commentStatus;
    }

    @JsonProperty("comment_status")
    public void setCommentStatus(String commentStatus) {
        this.commentStatus = commentStatus;
    }

    @JsonProperty("ping_status")
    public String getPingStatus() {
        return pingStatus;
    }

    @JsonProperty("ping_status")
    public void setPingStatus(String pingStatus) {
        this.pingStatus = pingStatus;
    }

    @JsonProperty("template")
    public String getTemplate() {
        return template;
    }

    @JsonProperty("template")
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty("wpfc_preacher")
    public List<Integer> getWpfcPreacher() {
        return wpfcPreacher;
    }

    @JsonProperty("wpfc_preacher")
    public void setWpfcPreacher(List<Integer> wpfcPreacher) {
        this.wpfcPreacher = wpfcPreacher;
    }

    @JsonProperty("wpfc_sermon_series")
    public List<Object> getWpfcSermonSeries() {
        return wpfcSermonSeries;
    }

    @JsonProperty("wpfc_sermon_series")
    public void setWpfcSermonSeries(List<Object> wpfcSermonSeries) {
        this.wpfcSermonSeries = wpfcSermonSeries;
    }

    @JsonProperty("wpfc_sermon_topics")
    public List<Object> getWpfcSermonTopics() {
        return wpfcSermonTopics;
    }

    @JsonProperty("wpfc_sermon_topics")
    public void setWpfcSermonTopics(List<Object> wpfcSermonTopics) {
        this.wpfcSermonTopics = wpfcSermonTopics;
    }

    @JsonProperty("wpfc_bible_book")
    public List<Integer> getWpfcBibleBook() {
        return wpfcBibleBook;
    }

    @JsonProperty("wpfc_bible_book")
    public void setWpfcBibleBook(List<Integer> wpfcBibleBook) {
        this.wpfcBibleBook = wpfcBibleBook;
    }

    @JsonProperty("wpfc_service_type")
    public List<Integer> getWpfcServiceType() {
        return wpfcServiceType;
    }

    @JsonProperty("wpfc_service_type")
    public void setWpfcServiceType(List<Integer> wpfcServiceType) {
        this.wpfcServiceType = wpfcServiceType;
    }

    @JsonProperty("sermon_audio")
    public String getSermonAudio() {
        return sermonAudio;
    }

    @JsonProperty("sermon_audio")
    public void setSermonAudio(String sermonAudio) {
        this.sermonAudio = sermonAudio;
    }

    @JsonProperty("sermon_audio_duration")
    public String getSermonAudioDuration() {
        return sermonAudioDuration;
    }

    @JsonProperty("sermon_audio_duration")
    public void setSermonAudioDuration(String sermonAudioDuration) {
        this.sermonAudioDuration = sermonAudioDuration;
    }

    @JsonProperty("_views")
    public String getViews() {
        return views;
    }

    @JsonProperty("_views")
    public void setViews(String views) {
        this.views = views;
    }

    @JsonProperty("bible_passage")
    public String getBiblePassage() {
        return biblePassage;
    }

    @JsonProperty("bible_passage")
    public void setBiblePassage(String biblePassage) {
        this.biblePassage = biblePassage;
    }

    @JsonProperty("sermon_description")
    public String getSermonDescription() {
        return sermonDescription;
    }

    @JsonProperty("sermon_description")
    public void setSermonDescription(String sermonDescription) {
        this.sermonDescription = sermonDescription;
    }

    @JsonProperty("sermon_video_embed")
    public String getSermonVideoEmbed() {
        return sermonVideoEmbed;
    }

    @JsonProperty("sermon_video_embed")
    public void setSermonVideoEmbed(String sermonVideoEmbed) {
        this.sermonVideoEmbed = sermonVideoEmbed;
    }

    @JsonProperty("sermon_video_url")
    public String getSermonVideoUrl() {
        return sermonVideoUrl;
    }

    @JsonProperty("sermon_video_url")
    public void setSermonVideoUrl(String sermonVideoUrl) {
        this.sermonVideoUrl = sermonVideoUrl;
    }

    @JsonProperty("sermon_bulletin")
    public String getSermonBulletin() {
        return sermonBulletin;
    }

    @JsonProperty("sermon_bulletin")
    public void setSermonBulletin(String sermonBulletin) {
        this.sermonBulletin = sermonBulletin;
    }

    @JsonProperty("_featured_url")
    public String getFeaturedUrl() {
        return featuredUrl;
    }

    @JsonProperty("_featured_url")
    public void setFeaturedUrl(String featuredUrl) {
        this.featuredUrl = featuredUrl;
    }

    @JsonProperty("sermon_date")
    public Integer getSermonDate() {
        return sermonDate;
    }

    @JsonProperty("sermon_date")
    public void setSermonDate(Integer sermonDate) {
        this.sermonDate = sermonDate;
    }

    @JsonProperty("_sermon_date_auto")
    public Boolean getSermonDateAuto() {
        return sermonDateAuto;
    }

    @JsonProperty("_sermon_date_auto")
    public void setSermonDateAuto(Boolean sermonDateAuto) {
        this.sermonDateAuto = sermonDateAuto;
    }

    @JsonProperty("_links")
    public Links getLinks() {
        return links;
    }

    @JsonProperty("_links")
    public void setLinks(Links links) {
        this.links = links;
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
