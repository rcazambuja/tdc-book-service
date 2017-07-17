package br.com.rcazambuja.book.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.rcazambuja.review.model.ReviewsClient;

@Repository
public class InMemoryBooksRepositoryImpl implements BooksRepository {
    private Map<String, Book> books = new HashMap<String, Book>();
    private ReviewsClient reviewsClient;

    @Autowired
    public InMemoryBooksRepositoryImpl(ReviewsClient reviewsClient) {
        this.reviewsClient = reviewsClient;
        createDefaultBooks();        
    }

    @Override
    public List<Book> getAll() {
        for(Book book : books.values()) {
            book.addReviews(reviewsClient.list(book.getIsbn()));
        }
        return Collections.unmodifiableList(new ArrayList<>(books.values()));
    }

    @Override
    public Book getByIsbn(String isbn) {
        Book book = books.get(isbn);
        if(book != null) {
            book.addReviews(reviewsClient.list(isbn));
        }
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
    
    private void createDefaultBooks() {
        this.saveOrUpdate(new Book("978-0134494166", 
                "Clean Architecture: A Craftsman's Guide to Software Structure and Design", 
                "Robert C. Martin", 2017, "Prentice Hall"));
        this.saveOrUpdate(new Book("978-0321356680", 
                "Effective Java (2nd Edition)", 
                "Joshua Bloch", 2008, "Addison-Wesley"));
        this.saveOrUpdate(new Book("978-1786461483", 
                "Building applications with Scala", 
                "Diego Pacheco", 2016, "Packt Publishing"));
        this.saveOrUpdate(new Book("978-0321774514", 
                "Refactoring Databases: Evolutionary Database Design", 
                "Scott J Ambler", 2006, "Addison-Wesley Professional"));
        this.saveOrUpdate(new Book("978-1491929124", 
                "Site Reliability Engineering: How Google Runs Production Systems", 
                "Chris Jones", 2016, "O'Reilly Media"));
        this.saveOrUpdate(new Book("978-1491950357", 
                "Building Microservices: Designing Fine-Grained Systems", 
                "Sam Newman", 2015, "O'Reilly Media"));
    }
}
