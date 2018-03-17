package org.churchsource.sermon.service;

public class ServiceTypeNamedQueryConstants {

  public static final String NAME_FIND_SERVICE_TYPE_BY_ID = "ServiceType.findServiceTypeById";
  public static final String QUERY_FIND_SERVICE_TYPE_BY_ID = "SELECT st FROM ServiceType st WHERE st.id = :id ";

  public static final String NAME_FIND_ALL_SERVICE_TYPES = "ServiceType.findAllServiceTypes";
  public static final String QUERY_FIND_ALL_SERVICE_TYPES = "SELECT st from ServiceType st";

}
