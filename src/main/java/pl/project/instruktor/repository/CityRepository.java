package pl.project.instruktor.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.instruktor.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
