package org.churchsource.sermon.book;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.churchsource.sermon.model.AbstractRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class BookRepository extends AbstractRepository<Book> {

  @PersistenceContext
  private EntityManager em;

  public List<Book> getAllBooks() {
    return em.createNamedQuery(BookNamedQueryConstants.NAME_FIND_ALL_BOOKS, Book.class).getResultList();
  }

  public Book getBookById(Long id) {
    List<Book> series = em.createNamedQuery(BookNamedQueryConstants.NAME_FIND_BOOK_BY_ID, Book.class).setParameter("id", id)
        .getResultList();
    return series == null || series.isEmpty() ? null : series.get(0); 
  }

  public void saveNewOrUpdateExistingBook(Book aSeries) {
    if(getBookById(aSeries.getId()) != null) {
      update(aSeries);
    } else {
      save(aSeries);
    }
  }
}