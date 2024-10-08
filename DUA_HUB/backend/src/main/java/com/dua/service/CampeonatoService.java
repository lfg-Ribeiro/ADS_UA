package com.dua.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dua.entity.Campeonato;
import com.dua.repository.CampeonatoRepository;

@Service
public class CampeonatoService {

    @Autowired
    private CampeonatoRepository campeonatoRepository;

    public List<Campeonato> findAll() {
        return campeonatoRepository.findAll();
    }

    public Campeonato save(Campeonato campeonato) {
        return campeonatoRepository.save(campeonato);
    }

    public Campeonato update(Campeonato campeonato, Long id) {
        return campeonatoRepository.save(campeonato);
    }

    public void deleteById(Long id) {
        campeonatoRepository.deleteById(id);
    }

    public Campeonato findById(Long id) {
        return campeonatoRepository.findById(id).orElse(null);
    }

    public List<Campeonato> findByNome(String nome) {
        return campeonatoRepository.findByNome(nome);
    }
}
