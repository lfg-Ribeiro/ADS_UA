package urna.urna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import urna.urna.entity.Eleitor;

import java.util.List;

@Repository
public interface EleitorRepository extends JpaRepository<Eleitor, Long> {
    List<Eleitor> findAllByStatusIn(List<String> statuses);
}
