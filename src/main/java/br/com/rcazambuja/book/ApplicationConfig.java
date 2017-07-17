package br.com.rcazambuja.book;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.rcazambuja.book.model.BooksRepository;
import br.com.rcazambuja.book.model.InMemoryBooksRepositoryImpl;

@Configuration
public class ApplicationConfig {
    @Bean
    public BooksRepository booksRepository(){
        return new InMemoryBooksRepositoryImpl();
    }
}
