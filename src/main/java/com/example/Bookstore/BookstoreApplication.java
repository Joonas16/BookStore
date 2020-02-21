package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner BookstoreDemo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			log.info("save a couple of books");
			crepository.save(new Category("Thriller"));
			crepository.save(new Category("Comedy"));
			crepository.save(new Category("Sports"));
			
			repository.save(new Book("Ernest Hemingwat", "A Farewell to Arms",  1929, 1232323-21, 24.99, crepository.findByName("Thriller").get(0)));
			repository.save(new Book("George Orwell", "Animal Farm", 1945, 221243-5, 12.99, crepository.findByName("Comedy").get(0)));
			repository.save(new Book("Matti Meikäläinen", "Nykäsen Matti", 2019, 221243-5, 22.99, crepository.findByName("Sports").get(0)));
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
