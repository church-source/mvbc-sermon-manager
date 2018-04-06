package org.churchsource.sermon.sermonplanner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.churchsource.sermon.googlesheet.planner.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true, noRollbackFor=Exception.class)
@Service
public class SermonPlannerFactory {

  @Autowired
  private SermonPlannerRepository sermonRepository;

  static DateFormat sermon_date_format = new SimpleDateFormat("yyyy-MM-dd");
  static DateFormat row_update_format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

  public SermonPlannerItem createSermonPlannerItem(Entry sermonPlannerGoogleEntry) throws ParseException {
    SermonPlannerItem sermonPlannerItem = new SermonPlannerItem();
    if(sermonPlannerGoogleEntry.getId() != null) {
      String googleRowId = sermonPlannerGoogleEntry.getId().get$t();
      if(googleRowId != null) {
        googleRowId = googleRowId.substring(googleRowId.lastIndexOf('/') + 1);
      } else {
        googleRowId = null;
      }
      sermonPlannerItem.setUniqueGoogleId(googleRowId);
    }
    if(sermonPlannerGoogleEntry.getUpdated() != null) {
      sermonPlannerItem.setUpdated(row_update_format.parse(sermonPlannerGoogleEntry.getUpdated().get$t()));
    }
    if(sermonPlannerGoogleEntry.getGsx$date() != null) {
      sermonPlannerItem.setDate(sermon_date_format.parse(sermonPlannerGoogleEntry.getGsx$date().get$t()));
    }
    if(sermonPlannerGoogleEntry.getGsx$ampm() != null) {
      sermonPlannerItem.setAmOrPm(SermonServiceAmPm.valueOf(sermonPlannerGoogleEntry.getGsx$ampm().get$t().toUpperCase()));
    }
    if(sermonPlannerGoogleEntry.getGsx$service() != null) {
      sermonPlannerItem.setService(sermonPlannerGoogleEntry.getGsx$service().get$t());
    }
    
    if(sermonPlannerGoogleEntry.getGsx$preacher() != null) {
      sermonPlannerItem.setPreacher(sermonPlannerGoogleEntry.getGsx$preacher().get$t());
    }
    if(sermonPlannerGoogleEntry.getGsx$title() != null) {
      sermonPlannerItem.setTitle(sermonPlannerGoogleEntry.getGsx$title().get$t());
    }
    if(sermonPlannerGoogleEntry.getGsx$passage() != null) {
      sermonPlannerItem.setPassage(sermonPlannerGoogleEntry.getGsx$passage().get$t());
    }
    if(sermonPlannerGoogleEntry.getGsx$series() != null) {
      sermonPlannerItem.setSeries(sermonPlannerGoogleEntry.getGsx$series().get$t());
    }
    return sermonPlannerItem;
  }

}