package br.com.rcazambuja.book.model;

import java.util.ArrayList;
import java.util.List;

import br.com.rcazambuja.review.model.Review;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private int year;
    private String publisher;
    private List<Review> reviews = new ArrayList<>();
    
    public Book() {
        super();
    }

    public Book(String isbn, String title, String author, int year, String publisher) {
        super();
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public int getYear() {
        return year;
    }
    
    public String getPublisher() {
        return publisher;
    }       
    
    public List<Review> getReviews() {
        return reviews;
    }

    public void addReviews(List<Review> reviews) {
        this.reviews.addAll(reviews);
    }
}
