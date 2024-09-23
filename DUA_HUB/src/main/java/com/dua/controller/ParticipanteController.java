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

import com.dua.entity.Participante;
import com.dua.service.ParticipanteService;

@RequestMapping("/participante")
@RestController
public class ParticipanteController {

	@Autowired
	public ParticipanteService participanteService;

	@PostMapping
	public ResponseEntity<String> save(@RequestBody Participante participante) {
		try {
			String message = this.participanteService.save(participante);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> update(@RequestBody Participante participante,@PathVariable Long id) {

		try {
			String message = this.participanteService.update(participante, id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping
	public ResponseEntity<String> delete(Participante participante,@PathVariable Long id) {
		try {
			String message = this.participanteService.delete(id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}	
	}

	@GetMapping
	public ResponseEntity<List<Participante>> findAll(){
		try {
			List<Participante> list = this.participanteService.findAll();
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Participante> findById(@PathVariable Long id) {
		try {
			Participante participante = this.participanteService.findById(id);
			return new ResponseEntity<>(participante, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

}