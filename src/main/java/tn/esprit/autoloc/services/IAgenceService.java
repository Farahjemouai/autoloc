package tn.esprit.autoloc.services;

import tn.esprit.autoloc.entities.Agence;

import java.util.List;
import java.util.Optional;

public interface IAgenceService {
    Agence addAgence(Agence agence);
    Agence updateAgence(Agence agence);
    void deleteAgence(Long id);
    Optional<Agence> getAgenceById(Long id);
    List<Agence> getAllAgences();
}
