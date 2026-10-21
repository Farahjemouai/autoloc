package tn.esprit.autoloc.entities;

import jakarta.persistence.*;
import lombok.*;
import tn.esprit.autoloc.entities.enums.Categorie;
import tn.esprit.autoloc.entities.enums.EtatVoiture;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Voiture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVoiture;

    private String marque;
    private String modele;
    private String immatriculation;
    private int annee;
    private double prixParJour;
    private int kilometrage;

    @Enumerated(EnumType.STRING)
    private Categorie categorie;

    @Enumerated(EnumType.STRING)
    private EtatVoiture etat;

    // Plusieurs voitures appartiennent à une agence
    @ManyToOne
    @JoinColumn(name = "id_agence")
    private Agence agence;

    // Une voiture peut avoir plusieurs contrats (historique)
    @OneToMany(mappedBy = "voiture", cascade = CascadeType.ALL)
    private List<Contrat> contrats = new ArrayList<>();
}
