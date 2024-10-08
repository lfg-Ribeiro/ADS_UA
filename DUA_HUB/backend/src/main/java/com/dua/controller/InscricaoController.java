package com.dua.controller;

import com.dua.entity.Inscricao;
import com.dua.service.InscricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {

    @Autowired
    private InscricaoService inscricaoService;

    @GetMapping
    public ResponseEntity<List<Inscricao>> getAllInscricoes() {
        List<Inscricao> inscricoes = inscricaoService.findAll();
        return ResponseEntity.ok(inscricoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inscricao> getInscricaoById(@PathVariable Long id) {
        return inscricaoService.findById(id)
                .map(inscricao -> ResponseEntity.ok(inscricao))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Inscricao> createInscricao(@RequestBody Inscricao inscricao) {
        Inscricao savedInscricao = inscricaoService.save(inscricao);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedInscricao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inscricao> updateInscricao(@PathVariable Long id, @RequestBody Inscricao inscricao) {
        if (!inscricaoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        inscricao.setId(id);
        Inscricao updatedInscricao = inscricaoService.save(inscricao);
        return ResponseEntity.ok(updatedInscricao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInscricao(@PathVariable Long id) {
        if (!inscricaoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        inscricaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
