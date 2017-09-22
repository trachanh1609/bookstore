package Haaga.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Haaga.bookstore.domain.Book;
import Haaga.bookstore.domain.BookRepository;
import Haaga.bookstore.domain.Category;
import Haaga.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository ) {
		return (args) -> {
			log.info("save a couple of categories");
			crepository.save(new Category("Business"));
			crepository.save(new Category("Fiction"));
			crepository.save(new Category("Law"));
			
			
			log.info("save a couple of books");
			brepository.save(new Book("John","Think Fast", "abc-35434", "2005", crepository.findByName("Business").get(0) ));
			brepository.save(new Book("Katy","Never Give Up", "gas-87554", "1998", crepository.findByName("Fiction").get(0)));	
			brepository.save(new Book("Jack","Go go", "kjhg-46547", "1953",crepository.findByName("Law").get(0) ));
			brepository.save(new Book("Vinny","Game of Programming", "jhg-87554", "1990", crepository.findByName("Fiction").get(0) ));
			
			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
