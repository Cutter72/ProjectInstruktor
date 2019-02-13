package pl.project.instruktor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.project.instruktor.model.Category;


import java.util.List;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("select u from Category u where u.parent = null")
    List<Category> findMainCategories();

}
