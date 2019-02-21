package pl.project.instruktor.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.project.instruktor.model.Availability;
import pl.project.instruktor.model.CurrentUser;
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
@RequestMapping("/panel/availability")
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
    public String setAvailability(@RequestParam(defaultValue = "1") int expiration,
                                  @AuthenticationPrincipal CurrentUser customUser,
                                  @RequestParam(defaultValue = "0") int pn,
                                  @RequestParam(defaultValue = "0") int wt,
                                  @RequestParam(defaultValue = "0") int sr,
                                  @RequestParam(defaultValue = "0") int cz,
                                  @RequestParam(defaultValue = "0") int pt,
                                  @RequestParam(defaultValue = "0") int so,
                                  @RequestParam(defaultValue = "0") int nd,
                                  @RequestParam(defaultValue = "0") int pnStartHour,
                                  @RequestParam(defaultValue = "0") int wtStartHour,
                                  @RequestParam(defaultValue = "0") int srStartHour,
                                  @RequestParam(defaultValue = "0") int czStartHour,
                                  @RequestParam(defaultValue = "0") int ptStartHour,
                                  @RequestParam(defaultValue = "0") int soStartHour,
                                  @RequestParam(defaultValue = "0") int ndStartHour,
                                  @RequestParam(defaultValue = "0") int pnEndHour,
                                  @RequestParam(defaultValue = "0") int wtEndHour,
                                  @RequestParam(defaultValue = "0") int srEndHour,
                                  @RequestParam(defaultValue = "0") int czEndHour,
                                  @RequestParam(defaultValue = "0") int ptEndHour,
                                  @RequestParam(defaultValue = "0") int soEndHour,
                                  @RequestParam(defaultValue = "0") int ndEndHour,
                                  Model model,
                                  RedirectAttributes redirectAttributes
    ) {
        int[][] weekSchedule = availabilityService.gatherDays(pn, wt, sr, cz, pt, so, nd,
                pnStartHour, wtStartHour, srStartHour, czStartHour, ptStartHour, soStartHour, ndStartHour,
                pnEndHour, wtEndHour, srEndHour, czEndHour, ptEndHour, soEndHour, ndEndHour);

        availabilityRepository.deleteAllByInstructorId(customUser.getUser().getId());
        lessonRepository.deleteAllByInstructorId(customUser.getUser().getId());
        for (Integer i = 0; i < weekSchedule.length; i++) {
            if (weekSchedule[i][0] > 0) {
                for (Long j = 0L; j < expiration; j++) {
                    LocalDateTime startPeriodicity = availabilityService.createDayTime(weekSchedule[i][1], weekSchedule[i][0]).plusDays(j * 7);
                    LocalDateTime endPeriodicity = availabilityService.createDayTime(weekSchedule[i][2], weekSchedule[i][0]).plusDays(j * 7);
                    Availability availabilityToAdd = availabilityService.createAvailability(startPeriodicity, endPeriodicity, weekSchedule[i][0], customUser.getUser().getId());
                    availabilityRepository.save(availabilityToAdd);

                    availabilityService.generateLessons(weekSchedule[i][1], weekSchedule[i][2], customUser.getUser().getId(), startPeriodicity, endPeriodicity);
                }
            }
        }
        redirectAttributes.addFlashAttribute("message", "Ustalono grfik!");
        return "redirect:/panel/schedule";
    }

}
