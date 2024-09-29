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
	void cenario01() {
		List<Participante> list = new ArrayList<>();
		list.add(new Participante(1l, "João Pedro", "123456", "Fisioterapia", "(99)9999-9999"));
		when(participanteRepository.findAll()).thenReturn(list);
		
		ResponseEntity<List<Participante>> retorno = this.participanteController.findAll();
		assertEquals(HttpStatus.OK , retorno.getStatusCode());
	}
}
