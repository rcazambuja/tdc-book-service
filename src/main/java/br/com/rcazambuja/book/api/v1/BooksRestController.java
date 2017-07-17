package br.com.rcazambuja.book.api.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rcazambuja.book.model.Book;
import br.com.rcazambuja.book.model.BooksRepository;

@RestController
@RequestMapping("/api/v1/books")
public class BooksRestController {
    private BooksRepository booksRepository;
    
    @Autowired
    public BooksRestController(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Book> list() {
        return booksRepository.getAll();
    }
    
    @RequestMapping(value = "/{isbn}", method = RequestMethod.GET)
    public Book get(@PathVariable String isbn) {
        Book book = booksRepository.getByIsbn(isbn);
        if(book == null) {
            throw new BookNotFoundException();
        }
        return book;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public Book create(@RequestBody Book book) {
        return booksRepository.saveOrUpdate(book);
    }
}
