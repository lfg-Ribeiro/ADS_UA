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

import com.dua.entity.Campeonato;
import com.dua.repository.CampeonatoRepository;

@SpringBootTest
public class CampeonatoControllerTest {

    @Autowired
    private CampeonatoController campeonatoController;

    @MockBean
    private CampeonatoRepository campeonatoRepository;

    @Test
    void testFindByNome() { // Teste para buscar campeonato por nome
        List<Campeonato> campeonatos = new ArrayList<>();
        campeonatos.add(new Campeonato(1L, "Campeonato C", null));

        when(campeonatoRepository.findByNome("Campeonato C")).thenReturn(campeonatos);

        ResponseEntity<List<Campeonato>> response = campeonatoController.getCampeonatosByNome("Campeonato C");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals("Campeonato C", response.getBody().get(0).getNome());
    }
}