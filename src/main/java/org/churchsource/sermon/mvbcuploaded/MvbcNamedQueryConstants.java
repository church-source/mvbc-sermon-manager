package org.churchsource.sermon.mvbcuploaded;

public class MvbcNamedQueryConstants {

  public static final String NAME_FIND_UPLOADED_SERMON_BY_ID = "Series.findUploadedSermonSById";
  public static final String QUERY_FIND_UPLOADED_SERMON_BY_ID = "SELECT s FROM MvbcUploadedSermon s WHERE s.id = :id ";

  public static final String NAME_FIND_ALL_UPLOADED_SERMONS = "Series.findUploadedSermons";
  public static final String QUERY_FIND_ALL_UPLOADED_SERMONS = "SELECT s from MvbcUploadedSermon s";

}
