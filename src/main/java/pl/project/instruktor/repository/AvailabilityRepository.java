package pl.project.instruktor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.instruktor.model.Availability;

import java.util.List;
@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {

    List<Availability> findAllByInstructorId(Long id);

    void deleteAllByInstructorId(Long id);

}
