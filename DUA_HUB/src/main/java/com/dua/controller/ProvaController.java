package com.dua.controller;

import com.dua.entity.Participante;
import com.dua.entity.Prova;
import com.dua.service.ProvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    
    @PutMapping("/{id}")
	public ResponseEntity<String> update(@RequestBody Prova prova,@PathVariable Long id) {

		try {
			String message = this.provaService.update(prova, id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}