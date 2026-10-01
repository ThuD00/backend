package c25.bookstore.wed;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import c25.bookstore.domain.AppUserRepository;

@Controller 
public class AppUserController {
  private final AppUserRepository repository;

  public  AppUserController(AppUserRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/users")
  public String userList(Model model) {
    model.addAttribute("users", repository.findAll());
    return "users";
  }
}
