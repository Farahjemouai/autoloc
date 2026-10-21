package tn.esprit.autoloc.entities;

import jakarta.persistence.*;
import lombok.*;
import tn.esprit.autoloc.entities.enums.Role;

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
}
