package com.dua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dua.entity.Participante;


public interface ParticipanteRepository extends JpaRepository<Participante, Long>{
	
	public List<Participante> findByNome(String nome);
	
	public List<Participante> findByMatricula(String matricula);
	
	public List<Participante> findByCurso(String curso);

}