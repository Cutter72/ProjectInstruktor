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

    public int[][] gatherDays(int pn, int wt, int sr, int cz, int pt, int so, int nd,
                              int pnStartHour, int wtStartHour, int srStartHour, int czStartHour, int ptStartHour, int soStartHour, int ndStartHour,
                              int pnEndHour, int wtEndHour, int srEndHour, int czEndHour, int ptEndHour, int soEndHour, int ndEndHour
    ) {
        int[][] week = new int[7][3];
        week[0][0] = pn;
        week[0][1] = pnStartHour;
        week[0][2] = pnEndHour;
        week[1][0] = wt;
        week[1][1] = wtStartHour;
        week[1][2] = wtEndHour;
        week[2][0] = sr;
        week[2][1] = srStartHour;
        week[2][2] = srEndHour;
        week[3][0] = cz;
        week[3][1] = czStartHour;
        week[3][2] = czEndHour;
        week[5][0] = pt;
        week[5][1] = ptStartHour;
        week[5][2] = ptEndHour;
        week[4][0] = so;
        week[4][1] = soStartHour;
        week[4][2] = soEndHour;
        week[6][0] = nd;
        week[6][1] = ndStartHour;
        week[6][2] = ndEndHour;
        for (int i = 0; i < week.length; i++) {
            if (week[i][1] > week[i][2]) {
                int tmp = week[i][1];
                week[i][1] = week[i][2];
                week[i][2] = tmp;
            }
        }
        return week;
    }

    public void generateLessons(int startHour, int endHour, Long instructorId, LocalDateTime startPeriodicity, LocalDateTime endPeriodicity) {
        for (int j = startHour; j <= endHour; j++) {
            Lesson newLesson = new Lesson();
            newLesson.setStartTime(startPeriodicity.withHour(j));
            newLesson.setEndTime(endPeriodicity.withHour(j + 1));
            newLesson.setInstructor(userRepository.getOne(instructorId));
            lessonRepository.save(newLesson);
        }
    }

    public Availability createAvailability(LocalDateTime startPeriodicity, LocalDateTime endPeriodicity, int dayId, Long instructorId) {
        Day day = dayRepository.getOne((long) dayId);
        Availability availability = new Availability();
        availability.setStartTime(startPeriodicity);
        availability.setEndTime(endPeriodicity);
        availability.setDay(day);
        availability.setInstructor(userRepository.getOne(instructorId));
        return availability;
    }

    public LocalDateTime createDayTime(int hour, int dayId) {
        return LocalDateTime.now().with(DayOfWeek.of(dayId)).withHour(hour).withMinute(0).withSecond(0).withNano(0);
    }
}
