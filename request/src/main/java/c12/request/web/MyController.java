package c12.request.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @GetMapping (value = "/hello")
    @ResponseBody
    public String hello(
        @RequestParam (value="name") String PersonName, 
        @RequestParam (value="location") String LocationNow) {
        
            return "Welcome to the " + LocationNow + " " + PersonName + "!";
    }

}
