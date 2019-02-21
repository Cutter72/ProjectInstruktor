package pl.project.instruktor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.instruktor.model.Day;

public interface DayRepository extends JpaRepository<Day, Long> {
}
