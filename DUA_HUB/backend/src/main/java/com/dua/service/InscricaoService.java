package com.dua.service;

import com.dua.entity.Inscricao;
import com.dua.repository.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscricaoService {

    @Autowired
    private InscricaoRepository inscricaoRepository;

    public List<Inscricao> findAll() {
        return inscricaoRepository.findAll();
    }

    public Optional<Inscricao> findById(Long id) {
        return inscricaoRepository.findById(id);
    }

    public Inscricao save(Inscricao inscricao) {
        return inscricaoRepository.save(inscricao);
    }

    public void deleteById(Long id) {
        inscricaoRepository.deleteById(id);
    }
}
