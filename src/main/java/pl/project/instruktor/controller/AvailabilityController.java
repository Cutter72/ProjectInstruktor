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
import pl.project.instruktor.repository.LessonRepository;
import pl.project.instruktor.service.AvailabilityService;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/availability")
@Transactional
public class AvailabilityController {
    private final DayRepository dayRepository;
    private final LessonRepository lessonRepository;
    private final AvailabilityRepository availabilityRepository;
    private final AvailabilityService availabilityService;

    public AvailabilityController(DayRepository dayRepository, LessonRepository lessonRepository, AvailabilityRepository availabilityRepository, AvailabilityService availabilityService) {
        this.dayRepository = dayRepository;
        this.lessonRepository = lessonRepository;
        this.availabilityRepository = availabilityRepository;
        this.availabilityService = availabilityService;
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
                                  @RequestParam(defaultValue = "1") Long instructorId,
                                  @RequestParam(defaultValue = "0") int pn,
                                  @RequestParam(defaultValue = "0") int wt,
                                  @RequestParam(defaultValue = "0") int sr,
                                  @RequestParam(defaultValue = "0") int cz,
                                  @RequestParam(defaultValue = "0") int pt,
                                  @RequestParam(defaultValue = "0") int so,
                                  @RequestParam(defaultValue = "0") int nd
    ) {
        List<Integer> dayIdList = availabilityService.gatherDays(pn, wt, sr, cz, pt, so, nd);
        if (startHour > endHour) {
            int tmp = startHour;
            startHour = endHour;
            endHour = tmp;
        }
        availabilityRepository.deleteAllByInstructorId(instructorId);
        for (Integer dayId : dayIdList) {
            if (dayId > 0) {
                for (Long i = 0L; i < expiration; i++) {
                    LocalDateTime startPeriodicity = availabilityService.createDayTime(startHour,dayId).plusDays(i * 7);
                    LocalDateTime endPeriodicity = availabilityService.createDayTime(endHour,dayId).plusDays(i * 7);
                    Availability availabilityToAdd = availabilityService.createAvailability(startPeriodicity, endPeriodicity, dayId, instructorId);
                    availabilityRepository.save(availabilityToAdd);

                    lessonRepository.deleteAllByInstructorId(instructorId);
                    availabilityService.generateLessons(startHour,endHour, instructorId,startPeriodicity,endPeriodicity);
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
