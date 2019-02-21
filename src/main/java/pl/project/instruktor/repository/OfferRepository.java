package pl.project.instruktor.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.project.instruktor.model.Offer;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    @Query("select u from Offer u where u.user.id = ?1")
    List<Offer> getAllByUserId(long user_id);

    @Query("select u from Offer u where u.user.id = ?1 order by u.created desc")
    List<Offer> getAllByUserIdSortByDate(long user_id);

    @Query("select u from Offer u order by u.created desc")
    List<Offer> getAllAndOrderByCreated();
}
