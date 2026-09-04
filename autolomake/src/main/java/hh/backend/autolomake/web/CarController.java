package hh.backend.autolomake.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import hh.backend.autolomake.domain.Car;

@Controller
public class CarController {
    //get palauttaa tyhjä autolomakkeen
    @GetMapping("/newcar")
    public String getNewCarForm(Model model) {
        model.addAttribute("car", new Car());
        return "carform";
    }
    //Post käsittelee lomakkeelta lähetetyt tiedot
    @PostMapping("/savecar")
    public String saveNewCar(@ModelAttribute Car car) {
        //todo: välitä auton tiedot Modelin avulla käyttö
        //liittymätemplatelle
        return "result";
    }
}
