package pl.project.instruktor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.instruktor.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
