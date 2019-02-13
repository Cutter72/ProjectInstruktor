package pl.project.instruktor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.project.instruktor.model.City;
import pl.project.instruktor.model.Province;
import pl.project.instruktor.repository.CityRepository;
import pl.project.instruktor.repository.ProvinceRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/panel/city")
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
        return "redirect:/panel/city";
    }

    @GetMapping("")
    public String cityList(Model model) {
        model.addAttribute("cityList", cityRepository.findAll());
        return "city";
    }

    @GetMapping("/add")
    public String cityForm(@ModelAttribute City city){
        return "cityAdd";
    }

    @PostMapping("/add")
    public String cityForm(@Valid City city, BindingResult result){
        if (result.hasErrors()) {
            return "cityAdd";
        }
        cityRepository.save(city);
        return "redirect:/panel/city";
    }

    @GetMapping("/delete/{id}")
    public String removeCity(@PathVariable long id, Model model) {
        City cityToRemove = cityRepository.getOne(id);
        model.addAttribute("cityToRemove", cityToRemove);
        return "cityDelete";
    }

    @PostMapping("/delete/{id}")
    public String removeCitySuccess(@PathVariable long id) {
        City cityToRemove = cityRepository.getOne(id);
        cityRepository.delete(cityToRemove);
        return "redirect:/panel/city";
    }

    @GetMapping("/edit/{id}")
    public String editCity(@PathVariable long id, Model model) {
        City cityToEdit = cityRepository.getOne(id);
        model.addAttribute("city", cityToEdit);
        return "cityEdit";
    }

    @PostMapping("/edit/{id}")
    public String editCitySuccess(@Valid City city, BindingResult result) {
        if (result.hasErrors()) {
            return "cityEdit";
        }
        cityRepository.save(city);
        return "redirect:/panel/city";
    }
}
