package br.com.rcazambuja.book.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryBooksRepositoryImpl implements BooksRepository {
    private Map<String, Book> books;

    public InMemoryBooksRepositoryImpl() {
        books = defaultBooks();
    }

    @Override
    public List<Book> getAll() {
        return Collections.unmodifiableList(new ArrayList<>(books.values()));
    }

    @Override
    public Book getByIsbn(String isbn) {
        return books.get(isbn);
    }

    @Override
    public Book saveOrUpdate(Book book) {
        books.put(book.getIsbn(), book);
        return book;
    }

    @Override
    public void delete(Book book) {
        books.remove(book.getIsbn());
    }
    
    private Map<String, Book> defaultBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("978-0134494166", 
                "Clean Architecture: A Craftsman's Guide to Software Structure and Design", 
                "Robert C. Martin", 2017, "Prentice Hall"));
        books.add(new Book("978-0321356680", 
                "Effective Java (2nd Edition)", 
                "Joshua Bloch", 2008, "Addison-Wesley"));
        books.add(new Book("978-1786461483", 
                "Building applications with Scala", 
                "Diego Pacheco", 2016, "Packt Publishing"));
        books.add(new Book("978-0321774514", 
                "Refactoring Databases: Evolutionary Database Design", 
                "Scott J Ambler", 2006, "Addison-Wesley Professional"));
        books.add(new Book("978-1491929124", 
                "Site Reliability Engineering: How Google Runs Production Systems", 
                "Chris Jones", 2016, "O'Reilly Media"));
        books.add(new Book("978-1491950357", 
                "Building Microservices: Designing Fine-Grained Systems", 
                "Sam Newman", 2015, "O'Reilly Media"));
        
        return books.stream().collect(
                Collectors.toMap(x -> x.getIsbn(), x -> x));
    }
}
