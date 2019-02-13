package pl.project.instruktor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.instruktor.model.Province;
@Repository
public interface ProvinceRepository extends JpaRepository<Province, Long> {
}
