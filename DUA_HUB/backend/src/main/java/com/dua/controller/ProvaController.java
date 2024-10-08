package com.dua.controller;

import com.dua.entity.Participante;
import com.dua.entity.Prova;
import com.dua.service.ProvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
    
    @GetMapping("/findByNome")
    public ResponseEntity<List<Prova>> findByNome(@RequestParam String nome){
    	try {
			List<Prova> list = this.provaService.findByNome(nome);
    		return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
    }
    
    @GetMapping("/findByLocal")
    public ResponseEntity<List<Prova>> findByLocal(@RequestParam String local){
    	try {
    		List<Prova> list = this.provaService.findByLocal(local);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
    }
    
    @GetMapping("/findByParticipante")
    public ResponseEntity<List<Prova>> findByParticipantes(@RequestParam Long idParticipante){
    	try {
    		List<Prova> list = this.provaService.findByParticipantes(idParticipante);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
    }
}