package org.churchsource.sermon.service;

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
@Table(name="service_type")
@NamedQueries({
  @NamedQuery(name = ServiceTypeNamedQueryConstants.NAME_FIND_SERVICE_TYPE_BY_ID, query = ServiceTypeNamedQueryConstants.QUERY_FIND_SERVICE_TYPE_BY_ID),
  @NamedQuery(name = ServiceTypeNamedQueryConstants.NAME_FIND_ALL_SERVICE_TYPES, query = ServiceTypeNamedQueryConstants.QUERY_FIND_ALL_SERVICE_TYPES)})
public class ServiceType extends SermonManagerEntity <Long> {

  private static final long serialVersionUID = -865182316865182131L;

  private String name;
}
