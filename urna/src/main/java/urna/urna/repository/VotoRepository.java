package urna.urna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import urna.urna.entity.Voto;

public interface VotoRepository extends JpaRepository<Voto, Long> {
}
