package Haaga.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Haaga.bookstore.domain.Book;
import Haaga.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			log.info("save a couple of books");
			repository.save(new Book("John","Think Fast", "abc-35434", "2005" ));
			repository.save(new Book("Katy","Never Give Up", "gas-87554", "1998"));	
			repository.save(new Book("Jack","Go go", "kjhg-46547", "1953" ));
			repository.save(new Book("Vinny","Game of Programming", "jhg-87554", "1990"));
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
