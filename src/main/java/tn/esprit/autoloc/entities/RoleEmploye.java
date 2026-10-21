package tn.esprit.autoloc.entities;

import jakarta.persistence.*;
import lombok.*;
import tn.esprit.autoloc.entities.enums.Role;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "role_employe")
public class RoleEmploye {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String description;

    // Un rôle est attribué à plusieurs employés
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<Employe> employes = new ArrayList<>();
}
