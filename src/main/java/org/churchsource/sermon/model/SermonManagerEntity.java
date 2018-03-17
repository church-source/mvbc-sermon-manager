package org.churchsource.sermon.model;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Abstract generic base class for all entities. Entities are model objects that
 * are persisted to the data store
 */

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@MappedSuperclass
public abstract class SermonManagerEntity<ID> implements Serializable, SMEntityInterface<ID> {

  private static final long serialVersionUID = -5358899441894113746L;

  @Id
  private ID id;

  public SermonManagerEntity(ID id) {
    this.id = id;
  }
}
