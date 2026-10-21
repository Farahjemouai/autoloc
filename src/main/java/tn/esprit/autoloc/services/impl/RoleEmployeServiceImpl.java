package tn.esprit.autoloc.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.RoleEmploye;
import tn.esprit.autoloc.repositories.RoleEmployeRepository;
import tn.esprit.autoloc.services.IRoleEmployeService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleEmployeServiceImpl implements IRoleEmployeService {

    private final RoleEmployeRepository roleEmployeRepository;

    @Override
    public RoleEmploye addRoleEmploye(RoleEmploye roleEmploye) {
        return roleEmployeRepository.save(roleEmploye);
    }

    @Override
    public RoleEmploye updateRoleEmploye(RoleEmploye roleEmploye) {
        return roleEmployeRepository.save(roleEmploye);
    }

    @Override
    public void deleteRoleEmploye(Long id) {
        roleEmployeRepository.deleteById(id);
    }

    @Override
    public Optional<RoleEmploye> getRoleEmployeById(Long id) {
        return roleEmployeRepository.findById(id);
    }

    @Override
    public List<RoleEmploye> getAllRoleEmployes() {
        return roleEmployeRepository.findAll();
    }
}
