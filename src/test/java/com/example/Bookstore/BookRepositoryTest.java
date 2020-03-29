package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test
    public void findByLastnameShouldReturnStudent() {
        List<Book> books = repository.findByTitle("Nykäsen Matti");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("Nykäsen Matti");
    }
    
    @Test
    public void createNewBook() {
    	Book book = new Book("Testii", "Testii", 15512, 125125, 34.5, new Category("BITE"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    

}