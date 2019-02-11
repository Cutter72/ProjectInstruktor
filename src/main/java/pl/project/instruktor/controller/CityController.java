package pl.project.instruktor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.project.instruktor.model.City;
import pl.project.instruktor.model.Province;
import pl.project.instruktor.repository.CityRepository;
import pl.project.instruktor.repository.ProvinceRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/city")
public class CityController {

    private final ProvinceRepository provinceRepository;
    private final CityRepository cityRepository;

    public CityController(ProvinceRepository provinceRepository, CityRepository cityRepository) {
        this.provinceRepository = provinceRepository;
        this.cityRepository = cityRepository;
    }

    @ModelAttribute("provinceList")
    public List<Province> provinceList(){
        return provinceRepository.findAll();
    }

    @GetMapping("/")
    public String cityListSlash(Model model){
        return "redirect:/city";
    }

    @GetMapping("")
    public String cityList(Model model) {
        model.addAttribute("cityList", cityRepository.findAll());
        return "cityList";
    }

    @GetMapping("/add")
    public String cityForm(@ModelAttribute City city){
        return "cityForm";
    }

    @PostMapping("/add")
    public String cityForm(@Valid City city, BindingResult result){
        if (result.hasErrors()) {
            return "cityForm";
        }
        cityRepository.save(city);
        return "redirect:/city";
    }
}
