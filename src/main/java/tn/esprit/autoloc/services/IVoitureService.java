package tn.esprit.autoloc.services;

import tn.esprit.autoloc.entities.Voiture;

import java.util.List;
import java.util.Optional;

public interface IVoitureService {
    Voiture addVoiture(Voiture voiture);
    Voiture updateVoiture(Voiture voiture);
    void deleteVoiture(Long id);
    Optional<Voiture> getVoitureById(Long id);
    List<Voiture> getAllVoitures();
}
