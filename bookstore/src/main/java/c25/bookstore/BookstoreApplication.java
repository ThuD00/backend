package c25.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import c25.bookstore.domain.Book;
import c25.bookstore.domain.BookRepository;
import c25.bookstore.domain.Category;
import c25.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
  private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
      log.info("save a couple books");
			brepository.save(new Book("The Hobbit", "J.R.R. Tolkien", 1937, "9780261102217", 15.90));
			brepository.save(new Book("Harry Potter", "J.K. Rowling", 1997, "9780747532699", 12.50));
			brepository.save(new Book("1984", "George Orwell", 1949, "9780451524935", 10.90));
		
      log.info("fetch all books");
		  for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

      log.info("save some categories");
      crepository.save(new Category("Fantasy"));
      crepository.save(new Category("Thriller"));
      crepository.save(new Category("Action"));

      log.info("fetch all categories");
		  for (Category category : crepository.findAll()) {
				log.info(category.toString());
			}
      
		};
	
  }

}
