package pl.project.instruktor.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.instruktor.model.Offer;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}
