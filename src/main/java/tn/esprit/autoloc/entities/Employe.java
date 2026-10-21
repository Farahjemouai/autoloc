package tn.esprit.autoloc.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmploye;

    private String nom;
    private String prenom;
    private String email;
    private String telephone;


    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEmploye role;


    @ManyToOne
    @JoinColumn(name = "id_agence")
    private Agence agence;


    @OneToMany(mappedBy = "employe", cascade = CascadeType.ALL)
    private List<Contrat> contrats = new ArrayList<>();
}
