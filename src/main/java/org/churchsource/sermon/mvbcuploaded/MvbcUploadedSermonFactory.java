package org.churchsource.sermon.mvbcuploaded;

import org.churchsource.sermon.mvbcuploaded.wp.WPMvbcUploadedSermon;
import org.churchsource.sermon.series.wp.WPSermonSeries;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
public class MvbcUploadedSermonFactory {


  public MvbcUploadedSermon createEntity(WPMvbcUploadedSermon wpMvbcUploadedSermon) {
    MvbcUploadedSermon aMvbcUploadedSermon = new MvbcUploadedSermon();
    //TODO set fields here
    return aMvbcUploadedSermon;
  }

}