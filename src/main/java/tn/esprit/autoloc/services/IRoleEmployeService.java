package tn.esprit.autoloc.services;

import tn.esprit.autoloc.entities.RoleEmploye;

import java.util.List;
import java.util.Optional;

public interface IRoleEmployeService {
    RoleEmploye addRoleEmploye(RoleEmploye roleEmploye);
    RoleEmploye updateRoleEmploye(RoleEmploye roleEmploye);
    void deleteRoleEmploye(Long id);
    Optional<RoleEmploye> getRoleEmployeById(Long id);
    List<RoleEmploye> getAllRoleEmployes();
}
