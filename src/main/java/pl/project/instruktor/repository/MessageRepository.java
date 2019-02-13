package pl.project.instruktor.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.instruktor.model.Message;


import java.util.List;
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {


    List<Message> findAllByRecipientUserId(long user_id);

    List<Message> findAllBySenderUserId(long user_id);

}
