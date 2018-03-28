package org.churchsource.sermon.preacher;

public class PreacherNamedQueryConstants {

  public static final String NAME_FIND_PREACHER_BY_ID = "Preacher.findPreacherById";
  public static final String QUERY_FIND_PREACHER_BY_ID = "SELECT f FROM Preacher f WHERE f.id = :id";

  public static final String NAME_FIND_PREACHER_BY_NAME = "Preacher.findPreacherByName";
  public static final String QUERY_FIND_PREACHER_BY_NAME = "SELECT f FROM Preacher f WHERE f.name = :name";

  public static final String NAME_FIND_ALL_PREACHERS = "Preacher.findAllPreachers";
  public static final String QUERY_FIND_ALL_PREACHERS = "select f from Preacher f";

}
