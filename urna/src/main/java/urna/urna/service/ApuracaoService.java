package urna.urna.service;

import org.springframework.stereotype.Service;
import urna.urna.entity.Apuracao;
import urna.urna.entity.Candidato;
import urna.urna.repository.CandidatoRepository;
import urna.urna.repository.VotoRepository;

import java.util.List;

@Service
public class ApuracaoService {

    private final CandidatoRepository candidatoRepository;
    private final VotoRepository votoRepository;

    public ApuracaoService(CandidatoRepository candidatoRepository, VotoRepository votoRepository) {
        this.candidatoRepository = candidatoRepository;
        this.votoRepository = votoRepository;
    }

    public Apuracao calcularApuracao() {
        List<Candidato> candidatosPrefeito = candidatoRepository.findByFuncao(1); // prefeito
        List<Candidato> candidatosVereador = candidatoRepository.findByFuncao(2); // vereador
        int totalVotos = (int) votoRepository.count();

        return new Apuracao(totalVotos, candidatosPrefeito, candidatosVereador);
    }
}
