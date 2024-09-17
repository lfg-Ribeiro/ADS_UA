package urna.urna.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urna.urna.entity.Candidato;
import urna.urna.repository.CandidatoRepository;

import java.util.List;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    public List<Candidato> findAll() {
        return candidatoRepository.findAll();
    }

    public Candidato findById(Long id) {
        return candidatoRepository.findById(id).orElse(null);
    }

    public Candidato save(Candidato candidato) {
        return candidatoRepository.save(candidato);
    }

    public void deleteById(Long id) {
        candidatoRepository.deleteById(id);
    }
}
