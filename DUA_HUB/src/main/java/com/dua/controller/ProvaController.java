package com.dua.controller;

import com.dua.entity.Prova;
import com.dua.service.ProvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provas")
public class ProvaController {

    @Autowired
    private ProvaService provaService;

    @GetMapping
    public List<Prova> getAllProvas() {
        return provaService.findAll();
    }

    @PostMapping
    public Prova createProva(@RequestBody Prova prova) {
        return provaService.save(prova);
    }

    @DeleteMapping("/{id}")
    public void deleteProva(@PathVariable Long id) {
        provaService.deleteById(id);
    }
}
