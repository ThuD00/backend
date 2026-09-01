package c21.thymeleaf.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
    @GetMapping("/hello")
    public String hello (
        @RequestParam(name = "name") String PersonName,
        @RequestParam(value = "age") int PersonAge, Model model) {
            //tapa siirtää dataa Controllista HTML-sivulle
            //reppu, johon Controller pakkaa tiedot HTML-sivua varten
            model.addAttribute("name", PersonName);
            model.addAttribute("age", PersonAge);
            return "index";
    }

}
