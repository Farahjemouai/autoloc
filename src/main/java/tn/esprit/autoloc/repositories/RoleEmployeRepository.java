package tn.esprit.autoloc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.entities.RoleEmploye;

@Repository
public interface RoleEmployeRepository extends JpaRepository<RoleEmploye, Long> {
}
