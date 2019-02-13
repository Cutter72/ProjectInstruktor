package pl.project.instruktor.service;

import org.springframework.stereotype.Service;
import pl.project.instruktor.model.Availability;
import pl.project.instruktor.model.Day;
import pl.project.instruktor.model.Lesson;
import pl.project.instruktor.repository.DayRepository;
import pl.project.instruktor.repository.LessonRepository;
import pl.project.instruktor.repository.UserRepository;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AvailabilityService {
    private final DayRepository dayRepository;
    private final UserRepository userRepository;
    private final LessonRepository lessonRepository;

    public AvailabilityService(DayRepository dayRepository, UserRepository userRepository, LessonRepository lessonRepository) {
        this.dayRepository = dayRepository;
        this.userRepository = userRepository;
        this.lessonRepository = lessonRepository;
    }

    public List<Integer> gatherDays(int pn, int wt, int sr, int cz, int pt, int so, int nd) {
        List<Integer> dayIdList = new ArrayList<>();
        dayIdList.add(pn);
        dayIdList.add(wt);
        dayIdList.add(sr);
        dayIdList.add(cz);
        dayIdList.add(pt);
        dayIdList.add(so);
        dayIdList.add(nd);
        return dayIdList;
    }

    public void generateLessons(int startHour, int endHour, Long instructorId, LocalDateTime startPeriodicity, LocalDateTime endPeriodicity) {
        lessonRepository.deleteAllByInstructorId(instructorId);
        for (int j = startHour; j <= endHour; j++) {
            Lesson newLesson = new Lesson();
            newLesson.setStartTime(startPeriodicity.withHour(j));
            newLesson.setEndTime(endPeriodicity.withHour(j+1));
            newLesson.setInstructor(userRepository.getOne(instructorId));
            lessonRepository.save(newLesson);
        }
    }

    public Availability createAvailability (LocalDateTime startPeriodicity, LocalDateTime endPeriodicity, int dayId, Long instructorId) {
        Day day = dayRepository.getOne((long)dayId);
        Availability availability = new Availability();
        availability.setStartTime(startPeriodicity);
        availability.setEndTime(endPeriodicity);
        availability.setDay(day);
        availability.setInstructor(userRepository.getOne(instructorId));
        return availability;
    }

    public LocalDateTime createDayTime (int hour, int dayId) {
        return LocalDateTime.now().with(DayOfWeek.of(dayId)).withHour(hour).withMinute(0).withSecond(0).withNano(0);
    }
}
