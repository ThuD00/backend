package c11.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @GetMapping(value = "/index")
    @ResponseBody
    public String index() {
        return "This is the main page";
    }

    @GetMapping(value = "/contact")
    @ResponseBody
    public String contact() {
        return "This is the contact page";
    }
}
