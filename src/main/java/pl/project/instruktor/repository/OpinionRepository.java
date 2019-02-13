package pl.project.instruktor.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.instruktor.model.Opinion;

public interface OpinionRepository extends JpaRepository<Opinion, Long> {
}
