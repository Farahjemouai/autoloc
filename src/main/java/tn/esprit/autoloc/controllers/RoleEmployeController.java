package tn.esprit.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.RoleEmploye;
import tn.esprit.autoloc.services.IRoleEmployeService;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@AllArgsConstructor
public class RoleEmployeController {

    private final IRoleEmployeService roleEmployeService;

    // POST /api/roles
    @PostMapping
    public ResponseEntity<RoleEmploye> addRoleEmploye(@RequestBody RoleEmploye roleEmploye) {
        RoleEmploye saved = roleEmployeService.addRoleEmploye(roleEmploye);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // GET /api/roles
    @GetMapping
    public ResponseEntity<List<RoleEmploye>> getAllRoleEmployes() {
        return ResponseEntity.ok(roleEmployeService.getAllRoleEmployes());
    }

    // GET /api/roles/{id}
    @GetMapping("/{id}")
    public ResponseEntity<RoleEmploye> getRoleEmployeById(@PathVariable Long id) {
        return roleEmployeService.getRoleEmployeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PUT /api/roles/{id}
    @PutMapping("/{id}")
    public ResponseEntity<RoleEmploye> updateRoleEmploye(@PathVariable Long id, @RequestBody RoleEmploye roleEmploye) {
        roleEmploye.setId(id);
        return ResponseEntity.ok(roleEmployeService.updateRoleEmploye(roleEmploye));
    }

    // DELETE /api/roles/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoleEmploye(@PathVariable Long id) {
        roleEmployeService.deleteRoleEmploye(id);
        return ResponseEntity.noContent().build();
    }
}
