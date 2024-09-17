package urna.urna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import urna.urna.entity.Candidato;
import java.util.List;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

    // find candidatos pela função (1- prefeito - 2- vereador)
    List<Candidato> findByFuncao(int funcao);
}