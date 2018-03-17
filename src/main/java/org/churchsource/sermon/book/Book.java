package org.churchsource.sermon.book;

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
@Table(name="book")
@NamedQueries({
  @NamedQuery(name = BookNamedQueryConstants.NAME_FIND_BOOK_BY_ID, query = BookNamedQueryConstants.QUERY_FIND_BOOK_BY_ID),
  @NamedQuery(name = BookNamedQueryConstants.NAME_FIND_ALL_BOOKS, query = BookNamedQueryConstants.QUERY_FIND_ALL_BOOKS)})
public class Book extends SermonManagerEntity <Long> {

  private static final long serialVersionUID = -865182316865182131L;

  private String name;
}
