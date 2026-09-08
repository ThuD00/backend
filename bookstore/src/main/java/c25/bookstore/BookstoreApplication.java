package c25.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import c25.bookstore.domain.Book;
import c25.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
  private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
      log.info("save a couple books");
			repository.save(new Book("The Hobbit", "J.R.R. Tolkien", 1937, "9780261102217", 15.90));
			repository.save(new Book("Harry Potter", "J.K. Rowling", 1997, "9780747532699", 12.50));
			repository.save(new Book("1984", "George Orwell", 1949, "9780451524935", 10.90));
		
      log.info("fetch all books");
		  for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
