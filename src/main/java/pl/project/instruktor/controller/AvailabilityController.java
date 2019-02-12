package pl.project.instruktor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.project.instruktor.model.Availability;
import pl.project.instruktor.repository.DayRepository;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/availability")
public class AvailabilityController {
    private final DayRepository dayRepository;

    public AvailabilityController(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
    }

    @GetMapping("/set/byday")
    public String setAvailabilityForm(Model model){
        model.addAttribute("dayList", dayRepository.findAll());
        return "setAvailability";
    }

    @PostMapping("/set/byday")
    public String setAvailability(Model model){

        return "setAvailability";
    }
}
