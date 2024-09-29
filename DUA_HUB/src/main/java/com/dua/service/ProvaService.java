package com.dua.service;

import com.dua.entity.Participante;
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
    
    public String update(Prova prova, Long id) {
        if (provaRepository.existsById(id)) {
            prova.setId(id);
            provaRepository.save(prova);
            return "Prova atualizada com sucesso!";
        } else {
            return "Prova não encontrada!";
        }
    }
}