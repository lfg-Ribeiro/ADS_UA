package urna.urna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import urna.urna.entity.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
}
