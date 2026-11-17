package tn.esprit.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Contrat;
import tn.esprit.autoloc.services.IContratService;

import java.util.List;

@RestController
@RequestMapping("/api/contrats")
@AllArgsConstructor
public class ContratController {

    private final IContratService contratService;

    // POST /api/contrats
    @PostMapping
    public ResponseEntity<Contrat> addContrat(@RequestBody Contrat contrat) {
        Contrat saved = contratService.addContrat(contrat);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // GET /api/contrats
    @GetMapping
    public ResponseEntity<List<Contrat>> getAllContrats() {
        return ResponseEntity.ok(contratService.getAllContrats());
    }

    // GET /api/contrats/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Contrat> getContratById(@PathVariable Long id) {
        return contratService.getContratById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PUT /api/contrats/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Contrat> updateContrat(@PathVariable Long id, @RequestBody Contrat contrat) {
        contrat.setIdContrat(id);
        return ResponseEntity.ok(contratService.updateContrat(contrat));
    }

    // DELETE /api/contrats/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContrat(@PathVariable Long id) {
        contratService.deleteContrat(id);
        return ResponseEntity.noContent().build();
    }
}
