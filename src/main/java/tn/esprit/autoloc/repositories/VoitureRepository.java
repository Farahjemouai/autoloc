package tn.esprit.autoloc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.entities.Voiture;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture, Long> {
}
