package pl.project.instruktor.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.instruktor.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
