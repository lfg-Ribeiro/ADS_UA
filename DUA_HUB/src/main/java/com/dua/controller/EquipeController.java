package com.dua.controller;

import com.dua.entity.Equipe;
import com.dua.repository.EquipeRepository;
import com.dua.service.EquipeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipes")
public class EquipeController {

    @Autowired
    private EquipeRepository equipeRepository;

    @Autowired
    private EquipeService equipeService;  // Se precisar usar a lógica do serviço

    @GetMapping
    public List<Equipe> getAllEquipes() {
        return equipeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipe> getEquipeById(@PathVariable Long id) {
        Optional<Equipe> equipe = equipeRepository.findById(id);
        if (equipe.isPresent()) {
            return ResponseEntity.ok(equipe.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Equipe> createEquipe(@RequestBody Equipe equipe) {
        Equipe novaEquipe = equipeRepository.save(equipe);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaEquipe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipe> updateEquipe(@PathVariable Long id, @RequestBody Equipe equipeAtualizada) {
        return equipeRepository.findById(id)
                .map(equipe -> {
                    equipe.setNome(equipeAtualizada.getNome());
                    Equipe equipeAtualizadaSalva = equipeRepository.save(equipe);
                    return ResponseEntity.ok(equipeAtualizadaSalva);
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipe(@PathVariable Long id) {
        if (equipeRepository.existsById(id)) {
            equipeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}