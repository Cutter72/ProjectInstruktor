package pl.project.instruktor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.project.instruktor.model.Category;
import pl.project.instruktor.model.Day;

import java.util.List;

public interface DayRepository extends JpaRepository<Day, Long> {

}
