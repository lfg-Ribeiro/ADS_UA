package com.dua.service;

import com.dua.entity.Equipe;
import com.dua.repository.EquipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EquipeServiceTest {

    @InjectMocks
    private EquipeService equipeService;

    @Mock
    private EquipeRepository equipeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);  // Inicializa os mocks
    }

    @Test
    void testSaveEquipe() {
        // dado isso
        Equipe equipe = new Equipe();
        equipe.setNome("Time A");
        when(equipeRepository.save(any(Equipe.class))).thenReturn(equipe);

        // quando
        Equipe resultado = equipeService.save(equipe);

        // entao =
        assertNotNull(resultado);
        assertEquals("Time A", resultado.getNome());
        verify(equipeRepository, times(1)).save(equipe);
    }

    @Test
    void testFindAllEquipes() {
        // dado isso
        Equipe equipe = new Equipe();
        equipe.setNome("Time A");
        when(equipeRepository.findAll()).thenReturn(Collections.singletonList(equipe));

        // quando
        List<Equipe> equipes = equipeService.findAll();

        // entao =
        assertNotNull(equipes);
        assertEquals(1, equipes.size());
        assertEquals("Time A", equipes.get(0).getNome());
        verify(equipeRepository, times(1)).findAll();
    }
}
