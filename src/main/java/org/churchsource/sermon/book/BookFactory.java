package org.churchsource.sermon.book;

import org.churchsource.sermon.book.wp.WPSermonBook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
public class BookFactory {
  public Book createEntity(WPSermonBook wpSermonBook) {
    Book aBook = new Book();
    aBook.setId(wpSermonBook.getId());
    aBook.setName(wpSermonBook.getName());
    return aBook;
  }

}