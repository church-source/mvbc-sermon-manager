package org.churchsource.sermon.series;

import org.churchsource.sermon.series.wp.WPSermonSeries;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
public class SeriesFactory {


  public Series createEntity(WPSermonSeries wpSeries) {
    Series aSeries = new Series();
    aSeries.setId(wpSeries.getId());
    aSeries.setName(wpSeries.getName());
    return aSeries;
  }

}