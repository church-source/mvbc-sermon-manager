package org.churchsource.sermon.series;

public class SeriesNamedQueryConstants {

  public static final String NAME_FIND_SERIES_BY_ID = "Series.findSeriesSById";
  public static final String QUERY_FIND_SERIES_BY_ID = "SELECT s FROM Series s WHERE s.id = :id ";

  public static final String NAME_FIND_SERIES_BY_NAME = "Series.findSeriesSByName";
  public static final String QUERY_FIND_SERIES_BY_NAME = "SELECT s FROM Series s WHERE s.name = :name ";

  public static final String NAME_FIND_ALL_SERIES = "Series.findAllSeries";
  public static final String QUERY_FIND_ALL_SERIES = "SELECT s from Series s";

}
