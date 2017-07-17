package br.com.rcazambuja.review.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ReviewsClientFallback implements ReviewsClient {
    @Override
    public List<Review> list(String isbn) {
        return new ArrayList<Review>();
    }
}
