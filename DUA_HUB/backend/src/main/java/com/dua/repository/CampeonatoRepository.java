package com.dua.repository;

import com.dua.entity.Campeonato;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CampeonatoRepository extends JpaRepository<Campeonato, Long> {
    List<Campeonato> findByNome(String nome);
}
