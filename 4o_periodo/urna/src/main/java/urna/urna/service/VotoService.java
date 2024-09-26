package urna.urna.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urna.urna.entity.Voto;
import urna.urna.repository.VotoRepository;

import java.util.List;

@Service
public class VotoService {

    @Autowired
    private VotoRepository votoRepository;

    public List<Voto> findAll() {
        return votoRepository.findAll();
    }

    public Voto findById(Long id) {
        return votoRepository.findById(id).orElse(null);
    }

    public Voto save(Voto voto) {
        return votoRepository.save(voto);
    }

    public void deleteById(Long id) {
        votoRepository.deleteById(id);
    }
}
