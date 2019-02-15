package pl.project.instruktor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.project.instruktor.model.Day;
import pl.project.instruktor.model.Lesson;
import pl.project.instruktor.repository.DayRepository;
import pl.project.instruktor.repository.LessonRepository;


import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/panel/schedule")
public class ScheduleController {
    private final DayRepository dayRepository;
    private final LessonRepository lessonRepository;

    public ScheduleController(DayRepository dayRepository, LessonRepository lessonRepository) {
        this.dayRepository = dayRepository;
        this.lessonRepository = lessonRepository;
    }

    @GetMapping("")
    public String home(Model model){
        List<Day> dayList = dayRepository.findAll().stream().sorted(Comparator.comparing(Day::getId)).collect(Collectors.toList());
        model.addAttribute("dayList", dayList);
        return "schedule";
    }

    @GetMapping("/{year}/{month}/{day}")
    public String scheduleDetails(@PathVariable String year,@PathVariable String month,@PathVariable String day, Model model){
        String date = year + "-" + Integer.toString(Month.valueOf(month.toUpperCase()).getValue()) + "-" + day;
        String dateTimeZero =  date+ " 0:00:00";
        String dateTimeMidnight =  date+ " 23:59:59";
        List<Lesson> lessonList = lessonRepository.findAllByStartTime(dateTimeZero,dateTimeMidnight);
        List<Day> dayList = dayRepository.findAll().stream().sorted(Comparator.comparing(Day::getId)).collect(Collectors.toList());
        model.addAttribute("dayList", dayList);
        model.addAttribute("lessonList", lessonList);
        for (Lesson lesson : lessonList) {
            System.out.println(lesson.getStartTime().getHour());
        }
        return "scheduleDetails";
    }
}
