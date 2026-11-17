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

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_voiture")
    private Voiture voiture;

    @ManyToOne
    @JoinColumn(name = "id_employe")
    private Employe employe;
}
