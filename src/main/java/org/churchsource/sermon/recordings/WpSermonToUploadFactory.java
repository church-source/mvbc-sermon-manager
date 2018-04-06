package org.churchsource.sermon.recordings;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.churchsource.sermon.book.BookRepository;
import org.churchsource.sermon.media.MediaItem;
import org.churchsource.sermon.media.MediaItemRepository;
import org.churchsource.sermon.mvbcuploaded.MvbcUploadedSermon;
import org.churchsource.sermon.mvbcuploaded.MvbcUploadedSermonRepository;
import org.churchsource.sermon.mvbcuploaded.wp.Title;
import org.churchsource.sermon.mvbcuploaded.wp.WPMvbcSermonToUpload;
import org.churchsource.sermon.mvbcuploaded.wp.WPMvbcUploadedSermon;
import org.churchsource.sermon.preacher.Preacher;
import org.churchsource.sermon.preacher.PreacherRepository;
import org.churchsource.sermon.preacher.wp.WPPreacher;
import org.churchsource.sermon.series.Series;
import org.churchsource.sermon.series.SeriesRepository;
import org.churchsource.sermon.sermonplanner.SermonPlannerItem;
import org.churchsource.sermon.sermonplanner.SermonPlannerRepository;
import org.churchsource.sermon.service.ServiceType;
import org.churchsource.sermon.service.ServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Transactional(readOnly = true)
@Service
@Slf4j
public class WpSermonToUploadFactory {

  @Autowired
  private MvbcUploadedSermonRepository mvbcUploadedSermonRepository;

  @Autowired
  private SermonPlannerRepository sermonPlannerRepository;
  
  @Autowired
  private MediaItemRepository mediaItemRepository;

  @Autowired
  private PreacherRepository preacherRepository;

  @Autowired
  private SeriesRepository seriesRepository;

  @Autowired
  private ServiceTypeRepository serviceTypeRepository;

  @Autowired
  private BookRepository bookRepository;

  //TODO reusing this probably should create a new one. 
  public WPMvbcSermonToUpload createSermonToUpload(Recording aRecording) {
    WPMvbcSermonToUpload sermonToUpload  = new WPMvbcSermonToUpload();

    MvbcUploadedSermon alreadyUploadedSermon = mvbcUploadedSermonRepository.getMvbcUploadedSermonByFileName(aRecording.getFileName());
    if(alreadyUploadedSermon == null) {
      log.info("New Sermon: " + aRecording.toString());
      SermonPlannerItem item = sermonPlannerRepository.getSermonPlannerItemByDateAndServiceTime(aRecording.getDate(), aRecording.getServiceAmOrPm());
      if(item != null) {
        log.info("New Sermon Details From Planner: " + item);
        MediaItem mediaItem = mediaItemRepository.getMediaItemByFileTitle(new SimpleDateFormat("yyyyMMdd", Locale.getDefault()). format(item.getDate())+ "-" + item.getAmOrPm().toString().toLowerCase());
        if(mediaItem  == null) {
          mediaItem = mediaItemRepository.getMediaItemByFileTitle(new SimpleDateFormat("yyyyMMdd", Locale.getDefault()). format(item.getDate())+ "-" + item.getAmOrPm().toString().toUpperCase());
        }
        if(mediaItem  != null) {
          log.info("Media Item of New Sermon: " + mediaItem.getId());
          sermonToUpload.setFeaturedMedia(mediaItem.getId());
          sermonToUpload.setStatus("publish");
          sermonToUpload.setType("wpfc_sermon");
          sermonToUpload.setTitle(item.getTitle());
          sermonToUpload.setSermonAudio("https://mvsongs.co.za/gdrive/sermons/" + aRecording.getFileName());
          sermonToUpload.setSermonDescription(item.getPassage());
          sermonToUpload.setSermonAudioDuration(aRecording.getRecordingLength());
          setPreacher(sermonToUpload, item);
          setSeries(sermonToUpload, item);
          setServiceType(sermonToUpload, item);
          //TODO set sermon date
          
          //TODO leave book out for now. 
          
          sermonToUpload.setBiblePassage(item.getPassage());
          sermonToUpload.setSermonDate((aRecording.getDate().getTime() / 1000L) + 7201L);
          return sermonToUpload;
        }
      } else {
        log.info("Existing Sermon: " + aRecording.toString());
      }
    }
    return null;
  }

  private void setServiceType(WPMvbcSermonToUpload sermonToUpload, SermonPlannerItem item) {
    String serviceType = item.getService();
    if(StringUtils.isNotBlank(serviceType)) {
      ServiceType aServiceType = serviceTypeRepository.getServiceTypeByName(serviceType);
      if(aServiceType != null) {
        List<Long> list = new ArrayList<Long>();
        list.add(aServiceType.getId());
        sermonToUpload.setWpfcServiceType(list);
      }
    }
  }

  private void setSeries(WPMvbcSermonToUpload sermonToUpload, SermonPlannerItem item) {
    String series = item.getSeries();
    if(StringUtils.isNotBlank(series)) {
      Series aSeries = seriesRepository.getSeriesByName(series);
      if(aSeries != null) {
        List<Long> list = new ArrayList<Long>();
        list.add(aSeries.getId());
        sermonToUpload.setWpfcSermonSeries(list);
      }
    }
  }

  private void setPreacher(WPMvbcSermonToUpload sermonToUpload, SermonPlannerItem item) {
    String preacherName = item.getPreacher();
    if(StringUtils.isNotBlank(preacherName)) {
      Preacher aPreacher = preacherRepository.getPreacherByName(preacherName);
      if(aPreacher != null) {
        List<Long> list = new ArrayList<Long>();
        list.add(aPreacher.getId());
        sermonToUpload.setWpfcPreacher(list);
      }
    }
  }

}