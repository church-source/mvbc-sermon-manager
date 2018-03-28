
package org.churchsource.sermon.mvbcuploaded.wp;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "title",
    "status",
    "type",
    "featured_media",
    "wpfc_preacher",
    "wpfc_sermon_series",
    "wpfc_sermon_topics",
    "wpfc_bible_book",
    "wpfc_service_type",
    "sermon_audio",
    "sermon_audio_duration",
    "bible_passage",
    "sermon_description",
    "_featured_url",
    "sermon_date"
})
@ToString
public class WPMvbcSermonToUpload {

    @JsonProperty("title")
    private String title;
    @JsonProperty("status")
    private String status;
    @JsonProperty("type")
    private String type;
    @JsonProperty("featured_media")
    private Long featuredMedia;
    @JsonProperty("wpfc_preacher")
    private List<Long> wpfcPreacher = null;
    @JsonProperty("wpfc_sermon_series")
    private List<Long> wpfcSermonSeries = null;
    @JsonProperty("wpfc_sermon_topics")
    private List<Long> wpfcSermonTopics = null;
    @JsonProperty("wpfc_bible_book")
    private List<Long> wpfcBibleBook = null;
    @JsonProperty("wpfc_service_type")
    private List<Long> wpfcServiceType = null;
    @JsonProperty("sermon_audio")
    private String sermonAudio;
    @JsonProperty("sermon_audio_duration")
    private String sermonAudioDuration;
    @JsonProperty("bible_passage")
    private String biblePassage;
    @JsonProperty("sermon_description")
    private String sermonDescription;
    @JsonProperty("sermon_date")
    private Long sermonDate;

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

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("featured_media")
    public Long getFeaturedMedia() {
        return featuredMedia;
    }

    @JsonProperty("featured_media")
    public void setFeaturedMedia(Long featuredMedia) {
        this.featuredMedia = featuredMedia;
    }


    @JsonProperty("wpfc_preacher")
    public List<Long> getWpfcPreacher() {
        return wpfcPreacher;
    }

    @JsonProperty("wpfc_preacher")
    public void setWpfcPreacher(List<Long> wpfcPreacher) {
        this.wpfcPreacher = wpfcPreacher;
    }

    @JsonProperty("wpfc_sermon_series")
    public List<Long> getWpfcSermonSeries() {
        return wpfcSermonSeries;
    }

    @JsonProperty("wpfc_sermon_series")
    public void setWpfcSermonSeries(List<Long> wpfcSermonSeries) {
        this.wpfcSermonSeries = wpfcSermonSeries;
    }

    @JsonProperty("wpfc_sermon_topics")
    public List<Long> getWpfcSermonTopics() {
        return wpfcSermonTopics;
    }

    @JsonProperty("wpfc_sermon_topics")
    public void setWpfcSermonTopics(List<Long> wpfcSermonTopics) {
        this.wpfcSermonTopics = wpfcSermonTopics;
    }

    @JsonProperty("wpfc_bible_book")
    public List<Long> getWpfcBibleBook() {
        return wpfcBibleBook;
    }

    @JsonProperty("wpfc_bible_book")
    public void setWpfcBibleBook(List<Long> wpfcBibleBook) {
        this.wpfcBibleBook = wpfcBibleBook;
    }

    @JsonProperty("wpfc_service_type")
    public List<Long> getWpfcServiceType() {
        return wpfcServiceType;
    }

    @JsonProperty("wpfc_service_type")
    public void setWpfcServiceType(List<Long> wpfcServiceType) {
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
    @JsonProperty("sermon_date")
    public Long getSermonDate() {
        return sermonDate;
    }

    @JsonProperty("sermon_date")
    public void setSermonDate(Long sermonDate) {
        this.sermonDate = sermonDate;
    }
}
