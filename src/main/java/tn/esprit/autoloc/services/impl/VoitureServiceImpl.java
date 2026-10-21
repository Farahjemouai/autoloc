package tn.esprit.autoloc.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Voiture;
import tn.esprit.autoloc.repositories.VoitureRepository;
import tn.esprit.autoloc.services.IVoitureService;

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
}
