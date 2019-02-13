package pl.project.instruktor.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.instruktor.model.Opinion;
@Repository
public interface OpinionRepository extends JpaRepository<Opinion, Long> {
}
