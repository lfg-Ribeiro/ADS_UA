package com.dua.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.net.ResponseCache;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.dua.entity.Participante;
import com.dua.entity.Prova;
import com.dua.repository.ProvaRepository;

@SpringBootTest
public class ProvaControllerTest {

	@Autowired
	ProvaController provacontroller;
	
	@MockBean
	ProvaRepository provaRepository;
	
	@Test
	void cenario01() {//findByNome
		List<Prova> list = new ArrayList<>();
		List<Participante> participantes = new ArrayList<>();
		
		list.add(new Prova(1L, "400m rasos", LocalDateTime.parse("2024-09-27T13:45:30"), "Ginasio Costa Cavalcanti", participantes));
		when(provaRepository.findByNome("400m rasos")).thenReturn(list);
		
		ResponseEntity<List<Prova>> retorno = this.provacontroller.findByNome("400m rasos");
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
	}
	
	@Test
	void cenario02() {//findByLocal
		List<Prova> list = new ArrayList<>();
		List<Participante> participantes = new ArrayList<>();
		
		list.add(new Prova(1L, "400m rasos", LocalDateTime.parse("2024-09-27T13:45:30"), "Ginasio Costa Cavalcanti", participantes));
		when(provaRepository.findByLocal("Ginasio Costa Cavalcanti")).thenReturn(list);
		
		ResponseEntity<List<Prova>> retorno = this.provacontroller.findByLocal("Ginasio Costa Cavalcanti");
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
	}
	
	@Test
	void cenario03() {//findByParticipante
		List<Prova> list = new ArrayList<>();
		List<Participante> participantes = new ArrayList<>();
		Participante participante = new Participante(1L, "João Pedro", "123456","Fisioterapia", "(99)9999-9999");
		participantes.add(participante);
		
		list.add(new Prova(1L, "400m rasos", LocalDateTime.parse("2024-09-27T13:45:30"), "Ginasio Costa Cavalcanti", participantes));
		when(provaRepository.findByParticipantes(participante)).thenReturn(list);
		
		ResponseEntity<List<Prova>> retorno = this.provacontroller.findByParticipantes(1L);
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
	}
}
