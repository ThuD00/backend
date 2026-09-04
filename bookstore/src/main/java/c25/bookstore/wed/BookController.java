package c25.bookstore.wed;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class BookController {
    @GetMapping("/index")
    public String index() {
        return "welcome";
    }
}
