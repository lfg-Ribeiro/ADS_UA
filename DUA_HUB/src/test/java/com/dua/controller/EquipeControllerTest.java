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

import com.dua.entity.Equipe;
import com.dua.repository.EquipeRepository;

@SpringBootTest
public class EquipeControllerTest {

    @Autowired
    private EquipeController equipeController;

    @MockBean
    private EquipeRepository equipeRepository;

    @Test
    void testFindAllEquipes() {
        // Criando uma lista simulada de equipes
        List<Equipe> equipes = new ArrayList<>();
        equipes.add(new Equipe(1L, "Time A"));
        equipes.add(new Equipe(2L, "Time B"));

        // Simulando o comportamento do repositório
        when(equipeRepository.findAll()).thenReturn(equipes);

        // Chamando o controlador e verificando a resposta
        List<Equipe> response = equipeController.getAllEquipes();
        assertEquals(2, response.size());
        assertEquals("Time A", response.get(0).getNome());
    }

    @Test
    void testCreateEquipe() {
        // Criando uma equipe simulada
        Equipe novaEquipe = new Equipe(1L, "Time C");

        // Simulando o comportamento do repositório ao salvar
        when(equipeRepository.save(novaEquipe)).thenReturn(novaEquipe);

        // Chamando o controlador e verificando a resposta
        Equipe response = equipeController.createEquipe(novaEquipe);
        assertEquals("Time C", response.getNome());
    }
}
