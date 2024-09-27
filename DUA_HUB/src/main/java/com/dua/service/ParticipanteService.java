package com.dua.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dua.entity.Participante;
import com.dua.repository.ParticipanteRepository;

@Service
public class ParticipanteService {

	@Autowired
	public ParticipanteRepository participanteRepository;
	
	public String save(Participante participante) {
		this.participanteRepository.save(participante);
		return "Participante salvo com sucesso!";
	}

    public String update(Participante participante, Long id) {
        if (participanteRepository.existsById(id)) {
            participante.setId(id);
            participanteRepository.save(participante);
            return "Participante atualizado com sucesso!";
        } else {
            return "Participante não encontrado!";
        }
    }

    public String delete(Long id) {
        if (participanteRepository.existsById(id)) {
            participanteRepository.deleteById(id);
            return "Participante deletado com sucesso!";
        } else {
            return "Participante não encontrado!";
        }
    }
	
	public List<Participante> findAll(){
		List<Participante> list = this.participanteRepository.findAll();
		return list;
	}
	
	public Participante findById(Long id) {
		Participante participante = this.participanteRepository.findById(id).get();
		return participante;
	}

    public void deleteAll() {
        participanteRepository.deleteAll();
    }

}