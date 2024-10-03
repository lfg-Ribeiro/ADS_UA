package com.dua.service;

import com.dua.entity.Equipe;
import com.dua.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class EquipeService {

    @Autowired
    private EquipeRepository equipeRepository;

    public List<Equipe> findAll() {
        return equipeRepository.findAll();
    }

    public Equipe save(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    public void deleteById(Long id) {
        try {
            equipeRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Equipe não encontrada com o id: " + id);
        }
    }

    public Optional<Equipe> findById(Long id) {
        return equipeRepository.findById(id);
    }
}