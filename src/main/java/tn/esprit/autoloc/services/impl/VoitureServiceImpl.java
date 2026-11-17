package tn.esprit.autoloc.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Voiture;
import tn.esprit.autoloc.repositories.VoitureRepository;
import tn.esprit.autoloc.services.IVoitureService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VoitureServiceImpl implements IVoitureService {

    private final VoitureRepository voitureRepository;

    @Override
    public Voiture addVoiture(Voiture voiture) {
        return voitureRepository.save(voiture);
    }

    @Override
    public Voiture updateVoiture(Voiture voiture) {
        return voitureRepository.save(voiture);
    }

    @Override
    public void deleteVoiture(Long id) {
        voitureRepository.deleteById(id);
    }

    @Override
    public Optional<Voiture> getVoitureById(Long id) {
        return voitureRepository.findById(id);
    }

    @Override
    public List<Voiture> getAllVoitures() {
        return voitureRepository.findAll();
    }

    // Question 1 : démarre 5s après le démarrage, puis toutes les 60s
    @Scheduled(initialDelay = 5000, fixedRate = 60000)
    public void actualiserEtatVehicules() {
        List<Voiture> voitures = voitureRepository.findAll();
        System.out.println("=== Actualisation des véhicules ===");
        System.out.println("Nombre total de véhicules : " + voitures.size());
        System.out.println("Date et heure : " + LocalDateTime.now());
        System.out.println("===================================");
    }

    // Question 3 : tous les lundis à 09h00
    @Scheduled(cron = "0 0 9 * * MON")
    public void genererRapportVehicules() {
        List<Voiture> voitures = voitureRepository.findAll();
        int total = voitures.size();
        System.out.println("========== RAPPORT VÉHICULES ==========");
        System.out.println("Nombre total de véhicules : " + total);
        System.out.println("Date et heure de génération : " + LocalDateTime.now());
        System.out.println("========================================");
    }
}
