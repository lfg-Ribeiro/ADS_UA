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
        // Defina as regras para processar o status do eleitor
        if (isEleitorApto(eleitor)) {
            eleitor.setStatus("APTO");
        } else {
            eleitor.setStatus("INAPTO");
        }
        return eleitorRepository.save(eleitor);
    }

    private boolean isEleitorApto(Eleitor eleitor) {
        // Exemplo de regra: se todos os campos obrigatórios estão preenchidos
        return eleitor.getNomeCompleto() != null &&
                eleitor.getProfissao() != null &&
                eleitor.getTelefoneCelular() != null;
    }

    public void deleteById(Long id) {
        eleitorRepository.deleteById(id);
    }
}
