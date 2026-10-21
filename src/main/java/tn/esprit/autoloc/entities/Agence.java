package tn.esprit.autoloc.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;

    private String nom;
    private String ville;
    private String adresse;
    private String telephone;

    // Une agence emploie plusieurs employés
    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employe> employes = new ArrayList<>();

    // Une agence possède plusieurs voitures
    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Voiture> voitures = new ArrayList<>();

    // Une agence sert plusieurs clients, un client peut être lié à plusieurs agences
    @ManyToMany
    @JoinTable(
            name = "agence_client",
            joinColumns = @JoinColumn(name = "id_agence"),
            inverseJoinColumns = @JoinColumn(name = "id_client")
    )
    private Set<Client> clients = new HashSet<>();
}
