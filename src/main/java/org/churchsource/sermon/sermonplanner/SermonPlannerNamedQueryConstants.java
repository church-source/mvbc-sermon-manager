package org.churchsource.sermon.sermonplanner;

public class SermonPlannerNamedQueryConstants {

  public static final String NAME_FIND_SERMON_PLANNER_ITEM_BY_ID = "SermonPlanner.findSermonPlannerItemById";
  public static final String QUERY_FIND_SERMON_PLANNER_ITEM_BY_ID = "SELECT sp FROM SermonPlannerItem sp WHERE sp.id = :id ";

  public static final String NAME_FIND_SERMON_PLANNER_ITEM_BY_DATE_AND_TIME = "SermonPlanner.findSermonPlannerItemByDateAndTime";
  public static final String QUERY_FIND_SERMON_PLANNER_ITEM_BY_DATE_AND_TIME = "SELECT sp FROM SermonPlannerItem sp WHERE sp.date = :date AND sp.amOrPm = :amOrPm";

  public static final String NAME_FIND_SERMON_PLANNER_ITEM_BY_UNIQUE_GOOGLE_ID = "SermonPlanner.findSermonPlannerItemByUniqueGoogleCode";
  public static final String QUERY_FIND_SERMON_PLANNER_ITEM_BY_UNIQUE_GOOGLE_ID = "SELECT sp FROM SermonPlannerItem sp WHERE sp.uniqueGoogleId = :code ";

  public static final String NAME_FIND_ALL_SERMON_PLANNER_ITEMS = "SermonPlanner.findAllSermonPlannerItems";
  public static final String QUERY_FIND_ALL_SERMON_PLANNER_ITEMS = "select sp from SermonPlannerItem sp";

}
