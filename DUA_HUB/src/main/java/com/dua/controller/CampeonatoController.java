package com.dua.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dua.entity.Campeonato;
import com.dua.service.CampeonatoService;

@RestController
@RequestMapping("/campeonatos")
public class CampeonatoController {

    @Autowired
    private CampeonatoService campeonatoService;

    @GetMapping
    public ResponseEntity<List<Campeonato>> getAllCampeonatos() {
        try {
            List<Campeonato> campeonatos = campeonatoService.findAll();
            return new ResponseEntity<>(campeonatos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<Campeonato> createCampeonato(@RequestBody Campeonato campeonato) {
        try {
            Campeonato savedCampeonato = campeonatoService.save(campeonato);
            return new ResponseEntity<>(savedCampeonato, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Campeonato> updateCampeonato(@PathVariable Long id, @RequestBody Campeonato campeonato) {
        try {
            Campeonato updatedCampeonato = campeonatoService.update(campeonato, id);
            return new ResponseEntity<>(updatedCampeonato, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCampeonato(@PathVariable Long id) {
        try {
            campeonatoService.deleteById(id);
            return new ResponseEntity<>("Campeonato deletado com sucesso", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Campeonato> getCampeonatoById(@PathVariable Long id) {
        try {
            Campeonato campeonato = campeonatoService.findById(id);
            return new ResponseEntity<>(campeonato, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
