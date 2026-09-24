package c25.bookstore.wed;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import c25.bookstore.domain.Book;
import c25.bookstore.domain.BookRepository;

@CrossOrigin 
@Controller 
@RequestMapping("/rest")
public class BookRestController {

  private BookRepository bookRepository;

  //konstruktori
  public BookRestController(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  //RESTful service to get all books 
  //book-luokka oliot => JSON listaksi -> web-selaimeen vastauksena
  @GetMapping("/books")
  public @ResponseBody List<Book> findAllBooksRest() {
    return (List<Book>) bookRepository.findAll();
  }

  //--11-- to get book by id
  @GetMapping("/books/{id}")
  public @ResponseBody Optional<Book> getOneBookRest(
          @PathVariable(name = "id") Long bookId) {
    return bookRepository.findById(bookId);
  }

  //--11-- to save new book
  @PostMapping(value="/books")
  public @ResponseBody Book saveBookRest(@RequestBody Book book){
    return bookRepository.save(book);
  }
}
