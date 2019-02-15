package pl.project.instruktor.service;

import lombok.Getter;
import org.springframework.stereotype.Service;
import pl.project.instruktor.model.Lesson;
import pl.project.instruktor.repository.LessonRepository;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Getter
public class LessonService {
    private final LessonRepository lessonRepository;
    private String pnDate;
    private String wtDate;
    private String srDate;
    private String czDate;
    private String ptDate;
    private String soDate;
    private String ndDate;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public List<Lesson> getPnLessons(int year, int month, int day, String userId) {
        LocalDateTime selectedDateTime = LocalDateTime.of(year, month, day, 0, 0, 0);

        int pn = selectedDateTime.with(DayOfWeek.MONDAY).getDayOfMonth();
        String pnDayStart = year + "-" + month + "-" + pn + " 0:00:00";
        String pnDayEnd = year + "-" + month + "-" + pn + " 23:59:59";
        this.pnDate = year + "." + month + "." + pn;
        return lessonRepository.findAllByStartTime(pnDayStart, pnDayEnd, userId);
    }

    public List<Lesson> getWtLessons(int year, int month, int day, String userId) {
        LocalDateTime selectedDateTime = LocalDateTime.of(year, month, day, 0, 0, 0);

        int wt = selectedDateTime.with(DayOfWeek.TUESDAY).getDayOfMonth();
        String wtDayStart = year + "-" + month + "-" + wt + " 0:00:00";
        String wtDayEnd = year + "-" + month + "-" + wt + " 23:59:59";
        this.wtDate = year + "." + month + "." + wt;
        return lessonRepository.findAllByStartTime(wtDayStart, wtDayEnd, userId);
    }

    public List<Lesson> getSrLessons(int year, int month, int day, String userId) {
        LocalDateTime selectedDateTime = LocalDateTime.of(year, month, day, 0, 0, 0);

        int sr = selectedDateTime.with(DayOfWeek.WEDNESDAY).getDayOfMonth();
        String srDayStart = year + "-" + month + "-" + sr + " 0:00:00";
        String srDayEnd = year + "-" + month + "-" + sr + " 23:59:59";
        this.srDate = year + "." + month + "." + sr;
        return lessonRepository.findAllByStartTime(srDayStart, srDayEnd, userId);
    }

    public List<Lesson> getCzLessons(int year, int month, int day, String userId) {
        LocalDateTime selectedDateTime = LocalDateTime.of(year, month, day, 0, 0, 0);

        int cz = selectedDateTime.with(DayOfWeek.THURSDAY).getDayOfMonth();
        String czDayStart = year + "-" + month + "-" + cz + " 0:00:00";
        String czDayEnd = year + "-" + month + "-" + cz + " 23:59:59";
        this.czDate = year + "." + month + "." + cz;
        return lessonRepository.findAllByStartTime(czDayStart, czDayEnd, userId);
    }

    public List<Lesson> getPtLessons(int year, int month, int day, String userId) {
        LocalDateTime selectedDateTime = LocalDateTime.of(year, month, day, 0, 0, 0);

        int pt = selectedDateTime.with(DayOfWeek.FRIDAY).getDayOfMonth();
        String ptDayStart = year + "-" + month + "-" + pt + " 0:00:00";
        String ptDayEnd = year + "-" + month + "-" + pt + " 23:59:59";
        this.ptDate = year + "." + month + "." + pt;
        return lessonRepository.findAllByStartTime(ptDayStart, ptDayEnd, userId);
    }

    public List<Lesson> getSoLessons(int year, int month, int day, String userId) {
        LocalDateTime selectedDateTime = LocalDateTime.of(year, month, day, 0, 0, 0);

        int so = selectedDateTime.with(DayOfWeek.SATURDAY).getDayOfMonth();
        String soDayStart = year + "-" + month + "-" + so + " 0:00:00";
        String soDayEnd = year + "-" + month + "-" + so + " 23:59:59";
        this.soDate = year + "." + month + "." + so;
        return lessonRepository.findAllByStartTime(soDayStart, soDayEnd, userId);
    }

    public List<Lesson> getNdLessons(int year, int month, int day, String userId) {
        LocalDateTime selectedDateTime = LocalDateTime.of(year, month, day, 0, 0, 0);

        int nd = selectedDateTime.with(DayOfWeek.SUNDAY).getDayOfMonth();
        String ndDayStart = year + "-" + month + "-" + nd + " 0:00:00";
        String ndDayEnd = year + "-" + month + "-" + nd + " 23:59:59";
        this.ndDate = year + "." + month + "." + nd;
        return lessonRepository.findAllByStartTime(ndDayStart, ndDayEnd, userId);
    }

}
