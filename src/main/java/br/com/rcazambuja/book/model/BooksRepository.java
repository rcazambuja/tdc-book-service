package br.com.rcazambuja.book.model;

import java.util.List;

public interface BooksRepository {
    List<Book> getAll();
    Book getByIsbn(String isbn);
    Book saveOrUpdate(Book book);
    void delete(Book book);
}
