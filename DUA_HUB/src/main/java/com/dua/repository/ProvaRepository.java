package com.dua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dua.entity.Participante;
import com.dua.entity.Prova;

public interface ProvaRepository extends JpaRepository<Prova, Long> {
	public List<Prova> findByNome(String nome);
	
	public List<Prova> findByLocal(String local);
	
	public List<Prova> findByParticipantes(Participante participantes);
}
