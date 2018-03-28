package org.churchsource.sermon.series;

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
@Table(name="series")
@NamedQueries({
  @NamedQuery(name = SeriesNamedQueryConstants.NAME_FIND_SERIES_BY_ID, query = SeriesNamedQueryConstants.QUERY_FIND_SERIES_BY_ID),
  @NamedQuery(name = SeriesNamedQueryConstants.NAME_FIND_SERIES_BY_NAME, query = SeriesNamedQueryConstants.QUERY_FIND_SERIES_BY_NAME),
  @NamedQuery(name = SeriesNamedQueryConstants.NAME_FIND_ALL_SERIES, query = SeriesNamedQueryConstants.QUERY_FIND_ALL_SERIES)})
public class Series extends SermonManagerEntity <Long> {

  private static final long serialVersionUID = -865182316865182131L;

  private String name;
}
