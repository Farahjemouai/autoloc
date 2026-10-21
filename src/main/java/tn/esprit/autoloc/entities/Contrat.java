package tn.esprit.autoloc.entities;

import jakarta.persistence.*;
import lombok.*;
import tn.esprit.autoloc.entities.enums.EtatContrat;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;

    private LocalDate dateDebut;
    private LocalDate dateFin;
    private double montantTotal;
    private int kilometrageRetour;

    @Enumerated(EnumType.STRING)
    private EtatContrat etat;

    // Plusieurs contrats peuvent concerner un même client
    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    // Plusieurs contrats peuvent porter sur une même voiture (historique)
    @ManyToOne
    @JoinColumn(name = "id_voiture")
    private Voiture voiture;

    // Plusieurs contrats peuvent être gérés par un même employé
    @ManyToOne
    @JoinColumn(name = "id_employe")
    private Employe employe;
}
