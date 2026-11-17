package tn.esprit.autoloc.services;

import tn.esprit.autoloc.entities.Contrat;

import java.util.List;
import java.util.Optional;

public interface IContratService {
    Contrat addContrat(Contrat contrat);
    Contrat updateContrat(Contrat contrat);
    void deleteContrat(Long id);
    Optional<Contrat> getContratById(Long id);
    List<Contrat> getAllContrats();
}
