package com.dua.service;

import com.dua.entity.Prova;
import com.dua.repository.ProvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvaService {

    @Autowired
    private ProvaRepository provaRepository;

    public List<Prova> findAll() {
        return provaRepository.findAll();
    }

    public Prova save(Prova prova) {
        return provaRepository.save(prova);
    }

    public void deleteById(Long id) {
        provaRepository.deleteById(id);
    }
}