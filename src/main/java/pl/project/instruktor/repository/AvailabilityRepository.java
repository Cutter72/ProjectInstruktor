package pl.project.instruktor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.instruktor.model.Availability;

public interface AvailabilityRepository extends JpaRepository<Availability, Long> {

}
