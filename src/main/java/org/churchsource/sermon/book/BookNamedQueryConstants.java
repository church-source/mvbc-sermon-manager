package org.churchsource.sermon.book;

public class BookNamedQueryConstants {

  public static final String NAME_FIND_BOOK_BY_ID = "Books.findBookById";
  public static final String QUERY_FIND_BOOK_BY_ID = "SELECT b FROM Book b WHERE b.id = :id ";

  public static final String NAME_FIND_ALL_BOOKS = "Books.findAllBooks";
  public static final String QUERY_FIND_ALL_BOOKS = "SELECT b from Book b";

}
