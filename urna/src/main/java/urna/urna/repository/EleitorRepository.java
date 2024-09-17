package urna.urna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import urna.urna.entity.Eleitor;

import java.util.List;

public interface EleitorRepository extends JpaRepository<Eleitor, Long> {
    List<Eleitor> findAllByStatusIn(List<String> statuses);
}
