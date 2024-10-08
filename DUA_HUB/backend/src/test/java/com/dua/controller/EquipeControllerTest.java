package com.dua.controller;
import com.dua.entity.Equipe;
import com.dua.repository.EquipeRepository;
import com.dua.service.EquipeService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import jakarta.persistence.EntityNotFoundException;

@SpringBootTest
public class EquipeControllerTest {

    @Autowired
    private EquipeController equipeController;

    @MockBean
    private EquipeRepository equipeRepository;

    @MockBean
    private EquipeService equipeService;

    @Test
    void testFindAllEquipes() {
        List<Equipe> equipes = new ArrayList<>();
        equipes.add(new Equipe(1L, "Time A"));
        equipes.add(new Equipe(2L, "Time B"));

        when(equipeRepository.findAll()).thenReturn(equipes);

        List<Equipe> response = equipeController.getAllEquipes();
        assertEquals(2, response.size());
        assertEquals("Time A", response.get(0).getNome());
    }

    @Test
    void testCreateEquipe() {
        Equipe novaEquipe = new Equipe(1L, "Time C");

        // Simular que o repositório salva a nova equipe
        when(equipeRepository.save(novaEquipe)).thenReturn(novaEquipe);

        ResponseEntity<Equipe> response = equipeController.createEquipe(novaEquipe);
        assertEquals("Time C", response.getBody().getNome());
    }

    @Test
    void testDeleteEquipe() {
        Long id = 1L;

        // Simula que o repositório indica que a equipe existe
        when(equipeRepository.existsById(id)).thenReturn(true);

        ResponseEntity<Void> response = equipeController.deleteEquipe(id);

        // Verifica se o status retornado é NO_CONTENT
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void testFindEquipeNotFound() {
        when(equipeRepository.findById(1L)).thenReturn(Optional.empty());

        ResponseEntity<Equipe> response = equipeController.getEquipeById(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testUpdateEquipe() {
        Long id = 1L;
        Equipe equipeExistente = new Equipe(id, "Time D");
        Equipe equipeAtualizada = new Equipe(id, "Time D Atualizado");

        // Simulação para retornar a equipe existente
        when(equipeRepository.findById(id)).thenReturn(Optional.of(equipeExistente));
        when(equipeRepository.save(equipeAtualizada)).thenReturn(equipeAtualizada);

        ResponseEntity<Equipe> response = equipeController.updateEquipe(id, equipeAtualizada);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Time D Atualizado", response.getBody().getNome());
    }

    @Test
    void testUpdateEquipeNotFound() {
        Long id = 1L;
        Equipe equipeAtualizada = new Equipe(id, "Time Inexistente");

        when(equipeRepository.findById(id)).thenReturn(Optional.empty());

        ResponseEntity<Equipe> response = equipeController.updateEquipe(id, equipeAtualizada);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testDeleteEquipeNotFound() {
        Long id = 1L;

        // Simula que a equipe não existe
        doThrow(new EntityNotFoundException("Equipe não encontrada com o id: " + id)).when(equipeService).deleteEquipe(id);

        ResponseEntity<Void> response = equipeController.deleteEquipe(id);

        // Verifica se o status retornado é NOT_FOUND
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}