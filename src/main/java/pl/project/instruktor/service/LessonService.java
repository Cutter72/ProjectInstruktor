package pl.project.instruktor.service;

import org.springframework.stereotype.Service;
import pl.project.instruktor.repository.LessonRepository;

@Service
public class LessonService {
    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public void getHours() {

    }
}
