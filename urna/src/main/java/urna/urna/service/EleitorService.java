package urna.urna.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urna.urna.entity.Eleitor;
import urna.urna.repository.EleitorRepository;

import java.util.List;

@Service
public class EleitorService {

    @Autowired
    private EleitorRepository eleitorRepository;

    public List<Eleitor> findAll() {
        return eleitorRepository.findAll();
    }

    public Eleitor findById(Long id) {
        return eleitorRepository.findById(id).orElse(null);
    }

    public Eleitor save(Eleitor eleitor) {
        return eleitorRepository.save(eleitor);
    }

    public void deleteById(Long id) {
        eleitorRepository.deleteById(id);
    }
}
