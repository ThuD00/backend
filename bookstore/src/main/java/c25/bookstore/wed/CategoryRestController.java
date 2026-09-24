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

import c25.bookstore.domain.Category;
import c25.bookstore.domain.CategoryRepository;

@CrossOrigin 
@Controller 
@RequestMapping("/rest")
public class CategoryRestController {

  private CategoryRepository categoryRepository;

  //konstruktori
  public CategoryRestController(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  //get all
  @GetMapping("/categories")
  public @ResponseBody List<Category> getCategoriesRest() {
    return (List<Category>) categoryRepository.findAll();
  }

  //get by id
  @GetMapping("/categories/{id}")
  public @ResponseBody Optional<Category> findCategoryRest(
          @PathVariable("id") Long Id) {
    return categoryRepository.findById(Id);
  }

  //save new cate
  @PostMapping("/categories")
  public @ResponseBody Category saveCategoryRest(@RequestBody Category category) {
    return categoryRepository.save(category);
  }
}
