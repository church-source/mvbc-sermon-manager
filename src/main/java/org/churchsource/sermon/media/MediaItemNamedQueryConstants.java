package org.churchsource.sermon.media;

public class MediaItemNamedQueryConstants {

  public static final String NAME_FIND_MEDIA_ITEM_BY_ID = "MediaItem.findMediaItemById";
  public static final String QUERY_FIND_MEDIA_ITEM_BY_ID = "SELECT mi FROM MediaItem mi WHERE mi.id = :id ";

  public static final String NAME_FIND_MEDIA_ITEM_BY_TITLE = "MediaItem.findMediaItemByTitle";
  public static final String QUERY_FIND_MEDIA_ITEM_BY_TITLE = "SELECT mi FROM MediaItem mi WHERE mi.title = :title ";

  public static final String NAME_FIND_ALL_MEDIA_ITEMS = "MediaItem.findAllMediaItems";
  public static final String QUERY_FIND_ALL_MEDIA_ITEMS = "select mi from MediaItem mi";

}
