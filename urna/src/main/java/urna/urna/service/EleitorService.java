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
        // Listar somente eleitores ativos e pendentes
        return eleitorRepository.findAllByStatusIn(List.of("APTO", "PENDENTE"));
    }

    public Eleitor findById(Long id) {
        return eleitorRepository.findById(id).orElse(null);
    }

    public Eleitor save(Eleitor eleitor) {
        eleitor.setStatus(determineStatus(eleitor));
        return eleitorRepository.save(eleitor);
    }

    public Eleitor update(Long id, Eleitor eleitor) {
        Eleitor existingEleitor = findById(id);
        if (existingEleitor == null) {
            return null;
        }
        if ("INATIVO".equals(existingEleitor.getStatus())) {
            eleitor.setStatus("INATIVO");
        } else {
            eleitor.setStatus(determineStatus(eleitor));
        }
        eleitor.setId(id);
        return eleitorRepository.save(eleitor);
    }

    public void deleteById(Long id) {
        Eleitor eleitor = findById(id);
        if (eleitor != null) {
            if ("VOTOU".equals(eleitor.getStatus())) {
                throw new RuntimeException("Usuário já votou. Não foi possível inativá-lo");
            }
            eleitor.setStatus("INATIVO");
            eleitorRepository.save(eleitor);
        }
    }

    private String determineStatus(Eleitor eleitor) {
        if (eleitor.getNomeCompleto() == null || eleitor.getTelefoneCelular() == null) {
            return "PENDENTE";
        }
        if (eleitor.getCpf() == null || eleitor.getEmail() == null) {
            return "PENDENTE";
        }
        if ("BLOQUEADO".equals(eleitor.getStatus())) {
            return "BLOQUEADO";
        }
        if ("VOTOU".equals(eleitor.getStatus())) {
            return "VOTOU";
        }
        return "APTO";
    }

    public void vote(Long eleitorId) {
        Eleitor eleitor = findById(eleitorId);
        if (eleitor == null) {
            throw new RuntimeException("Eleitor não encontrado");
        }
        if ("PENDENTE".equals(eleitor.getStatus())) {
            eleitor.setStatus("BLOQUEADO");
            eleitorRepository.save(eleitor);
            throw new RuntimeException("Usuário com cadastro pendente tentou votar. O usuário será bloqueado!");
        } else if ("APTO".equals(eleitor.getStatus())) {
            eleitor.setStatus("VOTOU");
            eleitorRepository.save(eleitor);
        }
    }
}