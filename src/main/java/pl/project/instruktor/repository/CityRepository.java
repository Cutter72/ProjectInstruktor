package pl.project.instruktor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.instruktor.model.City;

public interface CityRepository extends JpaRepository<City, Long> {
}
