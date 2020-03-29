package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

public class CategoryRepositoryTest {
	   @Autowired
	    private CategoryRepository repository;

	    @Test
	    public void findByLastnameShouldReturnStudent() {
	        List<Category> categories = repository.findByName("Thriller");
	        
	        assertThat(categories).hasSize(1);
	        assertThat(categories.get(0).getName()).isEqualTo("Thriller");
	    }
	    
	    @Test
	    public void createNewBook() {
	    	Category category = new Category("Testi");
	    	repository.save(category);
	    	assertThat(category.getId()).isNotNull();
	    }   
}
