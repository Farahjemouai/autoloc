package tn.esprit.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Agence;
import tn.esprit.autoloc.services.IAgenceService;

import java.util.List;

@RestController
@RequestMapping("/api/agences")
@AllArgsConstructor
public class AgenceController {

    private final IAgenceService agenceService;

    // POST /api/agences
    @PostMapping
    public ResponseEntity<Agence> addAgence(@RequestBody Agence agence) {
        Agence saved = agenceService.addAgence(agence);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // GET /api/agences
    @GetMapping
    public ResponseEntity<List<Agence>> getAllAgences() {
        return ResponseEntity.ok(agenceService.getAllAgences());
    }

    // GET /api/agences/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Agence> getAgenceById(@PathVariable Long id) {
        return agenceService.getAgenceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PUT /api/agences/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Agence> updateAgence(@PathVariable Long id, @RequestBody Agence agence) {
        agence.setIdAgence(id);
        return ResponseEntity.ok(agenceService.updateAgence(agence));
    }

    // DELETE /api/agences/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgence(@PathVariable Long id) {
        agenceService.deleteAgence(id);
        return ResponseEntity.noContent().build();
    }
}
