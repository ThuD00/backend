package c25.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
  // CategoryRepository inherits services like findAll(), findByid(), save(), deleteById()
  List<Category> findByName(String name);
}
