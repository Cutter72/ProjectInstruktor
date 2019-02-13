package pl.project.instruktor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.instruktor.model.Province;

public interface ProvinceRepository extends JpaRepository<Province, Long> {
}
