package pl.project.instruktor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.project.instruktor.model.Lesson;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    void deleteAllByInstructorId(Long id);

    @Query(value = "select * from lessons where lessons.start_time >= ?1 and lessons.start_time < ?2 and lessons.instructor_id = ?3", nativeQuery = true)
    List<Lesson> findAllByStartTime(String dayStart,String dayEnd, String id);
}
