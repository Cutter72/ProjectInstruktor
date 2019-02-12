package pl.project.instruktor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.instruktor.model.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
