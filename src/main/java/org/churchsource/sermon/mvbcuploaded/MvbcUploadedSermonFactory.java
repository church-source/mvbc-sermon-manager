package org.churchsource.sermon.mvbcuploaded;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.churchsource.sermon.mvbcuploaded.wp.WPMvbcUploadedSermon;
import org.churchsource.sermon.preacher.PreacherRepository;
import org.churchsource.sermon.series.SeriesRepository;
import org.churchsource.sermon.service.ServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import liquibase.util.file.FilenameUtils;

@Transactional(readOnly = true)
@Service
public class MvbcUploadedSermonFactory {

  @Autowired
  private PreacherRepository preacherRepository;

  @Autowired
  private ServiceTypeRepository serviceTypeRepository;

  @Autowired
  private SeriesRepository seriesRepository;

  public MvbcUploadedSermon createEntity(WPMvbcUploadedSermon wpMvbcUploadedSermon) throws MalformedURLException {
    MvbcUploadedSermon aMvbcUploadedSermon = new MvbcUploadedSermon();
    //TODO set fields here
    aMvbcUploadedSermon.setId(wpMvbcUploadedSermon.getId());
    Long sermonDateMillis = new Long(wpMvbcUploadedSermon.getSermonDate()) * 1000L;
    Long millisWithoutTimePart = (long) Math.floor(sermonDateMillis/86400000L) * 86400000L;
    System.out.println("Got here: " + millisWithoutTimePart);
    aMvbcUploadedSermon.setSermonDate(new Date(millisWithoutTimePart));

    if(wpMvbcUploadedSermon.getTitle() != null) {
      aMvbcUploadedSermon.setTitle(wpMvbcUploadedSermon.getTitle().getRendered());
    }
    String sermonAudioUrl = wpMvbcUploadedSermon.getSermonAudio();
    aMvbcUploadedSermon.setSermonAudio(sermonAudioUrl);
    if(sermonAudioUrl != null) {
      URL url = new URL(sermonAudioUrl);
      aMvbcUploadedSermon.setSermonAudioFileName(FilenameUtils.getName(url.getPath()).replaceAll("%20", " "));
    }
    
    aMvbcUploadedSermon.setBiblePassage(wpMvbcUploadedSermon.getBiblePassage());
    
    if(wpMvbcUploadedSermon.getWpfcPreacher() != null && !wpMvbcUploadedSermon.getWpfcPreacher().isEmpty())
    {
      Long preacherId = wpMvbcUploadedSermon.getWpfcPreacher().get(0);
      aMvbcUploadedSermon.setPreacher(preacherRepository.getPreacherById(preacherId));
    }
    
    if(wpMvbcUploadedSermon.getWpfcServiceType() != null && !wpMvbcUploadedSermon.getWpfcServiceType().isEmpty())
    {
      Long serviceTypeId = wpMvbcUploadedSermon.getWpfcServiceType().get(0);
      aMvbcUploadedSermon.setServiceType(serviceTypeRepository.getServiceTypeById(serviceTypeId));
    }

    if(wpMvbcUploadedSermon.getWpfcSermonSeries() != null && !wpMvbcUploadedSermon.getWpfcSermonSeries().isEmpty())
    {
      Long seriesId = wpMvbcUploadedSermon.getWpfcSermonSeries().get(0);
      aMvbcUploadedSermon.setSeries(seriesRepository.getSeriesById(seriesId));
    }

    aMvbcUploadedSermon.setFeaturedMedia(wpMvbcUploadedSermon.getFeaturedMedia());

    return aMvbcUploadedSermon;
  }
}