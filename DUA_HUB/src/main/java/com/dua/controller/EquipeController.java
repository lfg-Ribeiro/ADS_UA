package com.dua.controller;

import com.dua.entity.Equipe;
import com.dua.service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/equipes")
public class EquipeController {

    @Autowired
    private EquipeService equipeService;

    @GetMapping
    public List<Equipe> getAllEquipes() {
        return equipeService.findAll();
    }

    @PostMapping
    public ResponseEntity<Equipe> createEquipe(@RequestBody Equipe equipe) {
        if (equipe.getNome() == null || equipe.getNome().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(equipeService.save(equipe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipe(@PathVariable Long id) {
        try {
            equipeService.deleteEquipe(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipe> getEquipeById(@PathVariable Long id) {
        return equipeService.findById(id)
                .map(equipe -> ResponseEntity.ok(equipe))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipe> updateEquipe(@PathVariable Long id, @RequestBody Equipe equipe) {
        if (equipe.getNome() == null || equipe.getNome().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return equipeService.findById(id)
                .map(existingEquipe -> {
                    existingEquipe.setNome(equipe.getNome());
                    return ResponseEntity.ok(equipeService.save(existingEquipe));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
