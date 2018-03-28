package org.churchsource.sermon.preacher;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.churchsource.sermon.model.SermonManagerEntity;
import org.churchsource.sermon.preacher.PreacherNamedQueryConstants;

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
@SuppressWarnings("unused")
@Table(name="preacher")
@NamedQueries({
  @NamedQuery(name = PreacherNamedQueryConstants.NAME_FIND_PREACHER_BY_ID, query = PreacherNamedQueryConstants.QUERY_FIND_PREACHER_BY_ID),
  @NamedQuery(name = PreacherNamedQueryConstants.NAME_FIND_PREACHER_BY_NAME, query = PreacherNamedQueryConstants.QUERY_FIND_PREACHER_BY_NAME),
  @NamedQuery(name = PreacherNamedQueryConstants.NAME_FIND_ALL_PREACHERS, query = PreacherNamedQueryConstants.QUERY_FIND_ALL_PREACHERS)})
public class Preacher extends SermonManagerEntity <Long> {

  private static final long serialVersionUID = -865182316865182131L;

  private String name;
}
