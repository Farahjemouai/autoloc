package tn.esprit.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Voiture;
import tn.esprit.autoloc.services.IVoitureService;

import java.util.List;

@RestController
@RequestMapping("/api/voitures")
@AllArgsConstructor
public class VoitureController {

    private final IVoitureService voitureService;

    // POST /api/voitures
    @PostMapping
    public ResponseEntity<Voiture> addVoiture(@RequestBody Voiture voiture) {
        Voiture saved = voitureService.addVoiture(voiture);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // GET /api/voitures
    @GetMapping
    public ResponseEntity<List<Voiture>> getAllVoitures() {
        return ResponseEntity.ok(voitureService.getAllVoitures());
    }

    // GET /api/voitures/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Voiture> getVoitureById(@PathVariable Long id) {
        return voitureService.getVoitureById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PUT /api/voitures/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Voiture> updateVoiture(@PathVariable Long id, @RequestBody Voiture voiture) {
        voiture.setIdVoiture(id);
        return ResponseEntity.ok(voitureService.updateVoiture(voiture));
    }

    // DELETE /api/voitures/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVoiture(@PathVariable Long id) {
        voitureService.deleteVoiture(id);
        return ResponseEntity.noContent().build();
    }
}
