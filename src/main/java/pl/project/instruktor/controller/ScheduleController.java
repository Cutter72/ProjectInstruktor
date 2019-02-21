package pl.project.instruktor.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.project.instruktor.model.CurrentUser;
import pl.project.instruktor.model.Day;
import pl.project.instruktor.repository.DayRepository;
import pl.project.instruktor.service.LessonService;

import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/panel/schedule")
public class ScheduleController {
    private final DayRepository dayRepository;
    private final LessonService lessonService;

    public ScheduleController(DayRepository dayRepository, LessonService lessonService) {
        this.dayRepository = dayRepository;
        this.lessonService = lessonService;
    }

    @GetMapping("")
    public String home(Model model) {
        List<Day> dayList = dayRepository.findAll().stream().sorted(Comparator.comparing(Day::getId)).collect(Collectors.toList());
        model.addAttribute("dayList", dayList);
        return "schedule";
    }

    @GetMapping("/{year}/{month}/{day}")
    public String scheduleDetails(@PathVariable int year, @PathVariable String month, @PathVariable int day, Model model, @AuthenticationPrincipal CurrentUser customUser) {
        List<Day> dayList = dayRepository.findAll().stream().sorted(Comparator.comparing(Day::getId)).collect(Collectors.toList());
        model.addAttribute("dayList", dayList);

        int monthNumber = Month.valueOf(month.toUpperCase()).getValue();
        model.addAttribute("pnLessonList", lessonService.getPnLessons(year, monthNumber, day, customUser.getUser().getId().toString()));
        model.addAttribute("pnDate", lessonService.getPnDate());
        model.addAttribute("wtLessonList", lessonService.getWtLessons(year, monthNumber, day, customUser.getUser().getId().toString()));
        model.addAttribute("wtDate", lessonService.getWtDate());
        model.addAttribute("srLessonList", lessonService.getSrLessons(year, monthNumber, day, customUser.getUser().getId().toString()));
        model.addAttribute("srDate", lessonService.getSrDate());
        model.addAttribute("czLessonList", lessonService.getCzLessons(year, monthNumber, day, customUser.getUser().getId().toString()));
        model.addAttribute("czDate", lessonService.getCzDate());
        model.addAttribute("ptLessonList", lessonService.getPtLessons(year, monthNumber, day, customUser.getUser().getId().toString()));
        model.addAttribute("ptDate", lessonService.getPtDate());
        model.addAttribute("soLessonList", lessonService.getSoLessons(year, monthNumber, day, customUser.getUser().getId().toString()));
        model.addAttribute("soDate", lessonService.getSoDate());
        model.addAttribute("ndLessonList", lessonService.getNdLessons(year, monthNumber, day, customUser.getUser().getId().toString()));
        model.addAttribute("ndDate", lessonService.getNdDate());
        return "scheduleDetails";
    }
}
