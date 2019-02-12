package pl.project.instruktor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.project.instruktor.model.Availability;
import pl.project.instruktor.model.Day;
import pl.project.instruktor.repository.AvailabilityRepository;
import pl.project.instruktor.repository.DayRepository;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/availability")
public class AvailabilityController {
    private final DayRepository dayRepository;
    private final AvailabilityRepository availabilityRepository;

    public AvailabilityController(DayRepository dayRepository, AvailabilityRepository availabilityRepository) {
        this.dayRepository = dayRepository;
        this.availabilityRepository = availabilityRepository;
    }

    @GetMapping("/byday/add")
    public String setAvailabilityForm(Model model) {
        List<Day> dayList = dayRepository.findAll().stream().sorted(Comparator.comparing(Day::getId)).collect(Collectors.toList());
        model.addAttribute("dayList", dayList);
        return "setAvailability";
    }

    @PostMapping("/byday/add")
    public String setAvailability(@RequestParam int startHour, @RequestParam int endHour,
                                  @RequestParam(defaultValue = "1") int expiration,
                                  @RequestParam(defaultValue = "0") int pn,
                                  @RequestParam(defaultValue = "0") int wt,
                                  @RequestParam(defaultValue = "0") int sr,
                                  @RequestParam(defaultValue = "0") int cz,
                                  @RequestParam(defaultValue = "0") int pt,
                                  @RequestParam(defaultValue = "0") int so,
                                  @RequestParam(defaultValue = "0") int nd
    ) {
        List<Integer> dayIdList = new ArrayList<>();
        dayIdList.add(pn);
        dayIdList.add(wt);
        dayIdList.add(sr);
        dayIdList.add(cz);
        dayIdList.add(pt);
        dayIdList.add(so);
        dayIdList.add(nd);
        for (Integer dayId : dayIdList) {
            if (dayId > 0) {
                LocalDateTime now = LocalDateTime.now().with(DayOfWeek.of(dayId)).withMinute(0).withSecond(0).withNano(0);
                for (Long i = 0L; i < expiration; i++) {
                    Availability availability = new Availability();
                    availability.setStartTime(now.withHour(startHour).plusDays(i * 7));
                    availability.setEndTime(now.withHour(endHour).plusDays(i * 7));
                    availabilityRepository.save(availability);
                }
            }
        }
        return "redirect:/availability/byday/add";
    }

    @GetMapping("/test")
    public String test() {
        return "redirect:/availability/byday/add";
    }
}
