package tn.esprit.autoloc.services;

import tn.esprit.autoloc.entities.Employe;

import java.util.List;
import java.util.Optional;

public interface IEmployeService {
    Employe addEmploye(Employe employe);
    Employe updateEmploye(Employe employe);
    void deleteEmploye(Long id);
    Optional<Employe> getEmployeById(Long id);
    List<Employe> getAllEmployes();
}
