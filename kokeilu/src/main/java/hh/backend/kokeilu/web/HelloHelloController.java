package hh.backend.kokeilu.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloHelloController {
    //Metodi vastaa pyyntöön localhost:8080/terve,
    //jossa endpoint/päätepiste on /terve

    @GetMapping(value = "/terve")
    @ResponseBody
    public String sayTerve() {
        return "Terve sulle!";
    }

    //metodi vastaa pyyntöön localhost:8080/moi?nimi=Thu
    @GetMapping(value = "/moi")
    @ResponseBody
    public String sayMoi(@RequestParam (value ="nimi") String hkloNimi) {
        return "Moi " + hkloNimi;
    }
}
