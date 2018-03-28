package org.churchsource.sermon.media;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.churchsource.sermon.model.SermonManagerEntity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@EqualsAndHashCode (callSuper = true)
@Getter
@Setter
@ToString (callSuper = true)
@Entity
@Table(name="media_item")
@NamedQueries({
  @NamedQuery(name = MediaItemNamedQueryConstants.NAME_FIND_MEDIA_ITEM_BY_ID, query = MediaItemNamedQueryConstants.QUERY_FIND_MEDIA_ITEM_BY_ID),
  @NamedQuery(name = MediaItemNamedQueryConstants.NAME_FIND_MEDIA_ITEM_BY_TITLE, query = MediaItemNamedQueryConstants.QUERY_FIND_MEDIA_ITEM_BY_TITLE),
  @NamedQuery(name = MediaItemNamedQueryConstants.NAME_FIND_ALL_MEDIA_ITEMS, query = MediaItemNamedQueryConstants.QUERY_FIND_ALL_MEDIA_ITEMS)})
public class MediaItem extends SermonManagerEntity <Long> {

  private static final long serialVersionUID = -865182316865182131L;

  private String title;
  private String path;
}
