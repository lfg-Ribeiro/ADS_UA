package com.dua.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.dua.entity.Participante;
import com.dua.repository.ParticipanteRepository;

@SpringBootTest
public class ParticipanteControllerTest {
	
	@Autowired
	ParticipanteController participanteController;
	
	@MockBean
	ParticipanteRepository participanteRepository;
	
	@Test
	void cenario01() {//findall
		List<Participante> list = new ArrayList<>();
		list.add(new Participante(1l, "João Pedro", "123456", "Fisioterapia", "(99)9999-9999"));
		when(participanteRepository.findAll()).thenReturn(list);
		
		ResponseEntity<List<Participante>> retorno = this.participanteController.findAll();
		assertEquals(HttpStatus.OK , retorno.getStatusCode());
	}
	
	@Test
	void cenario02() {//findByNome
		List<Participante> list = new ArrayList<>();
		list.add(new Participante(1l, "Carlos", "123465", "Pedagogia", "(99)9999-9999"));
		when(participanteRepository.findByNome("Carlos")).thenReturn(list);
		
		ResponseEntity<List<Participante>> retorno = this.participanteController.findByNome("Carlos");
		assertEquals(HttpStatus.OK , retorno.getStatusCode());
	}
	
	@Test
	void cenario03() {//findByCurso
		List<Participante> list = new ArrayList<>();
		list.add(new Participante(1l, "Jorge", "123465", "Educação Fisica", "(99)9999-9999"));
		when(participanteRepository.findByNome("Educação Fisica")).thenReturn(list);
		
		ResponseEntity<List<Participante>> retorno = this.participanteController.findByNome("Educação Fisica");
		assertEquals(HttpStatus.OK , retorno.getStatusCode());
	}
	
	@Test
	void cenario04() {//findByMatricula
		List<Participante> list = new ArrayList<>();
		list.add(new Participante(1l, "Rafael", "122334", "Odontologia", "(99)9999-9999"));
		when(participanteRepository.findByNome("122334")).thenReturn(list);
		
		ResponseEntity<List<Participante>> retorno = this.participanteController.findByNome("122334");
		assertEquals(HttpStatus.OK , retorno.getStatusCode());
	}
}
