package Haaga.bookstore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import Haaga.bookstore.domain.Book;
import Haaga.bookstore.domain.BookRepository;
import Haaga.bookstore.domain.CategoryRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTests {
	
	@Autowired
	private BookRepository brepository;
	private CategoryRepository crepository;

	@Test
	public void findOneBookByAuthor() {
		List<Book> books = brepository.findByAuthor("Vinny");
		assertThat(books).hasSize(1);
	}

	@Test
	public void createNewBook() {
		Book newbook = new Book("Martin","Game of Fun", "hgas-2354", "2005", crepository.findByName("Business").get(0));
		brepository.save(newbook);
		assertThat(newbook.getId()).isNotNull();
	}
}
