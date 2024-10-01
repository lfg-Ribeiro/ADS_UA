package com.dua.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.dua.entity.Campeonato;
import com.dua.repository.CampeonatoRepository;

@SpringBootTest
public class CampeonatoServiceTest {

    @Autowired
    private CampeonatoService campeonatoService;

    @MockBean
    private CampeonatoRepository campeonatoRepository;

    @Test
    void testFindByNome() { // testando find by nome
        List<Campeonato> campeonatos = new ArrayList<>();
        campeonatos.add(new Campeonato(1L, "Campeonato X", null));

        // simulando resposta
        when(campeonatoRepository.findByNome("Campeonato X")).thenReturn(campeonatos);

        List<Campeonato> resultado = campeonatoService.findByNome("Campeonato X");

        // confirmando resultado
        assertEquals(1, resultado.size());
        assertEquals("Campeonato X", resultado.get(0).getNome());
    }
}