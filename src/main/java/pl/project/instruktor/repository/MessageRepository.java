package pl.project.instruktor.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.instruktor.model.Message;


import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {


    List<Message> findAllByRecipientUserId(long user_id);

    List<Message> findAllBySenderUserId(long user_id);

}
