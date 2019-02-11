package pl.project.instruktor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.project.instruktor.model.Category;


import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("select u from Category u where u.parent = null")
    List<Category> findMainCategories();

}
