package urna.urna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import urna.urna.entity.Eleitor;

public interface EleitorRepository extends JpaRepository<Eleitor, Long> {
}
