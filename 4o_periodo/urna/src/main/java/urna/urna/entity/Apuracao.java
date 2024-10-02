package urna.urna.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import urna.urna.entity.Candidato;
import java.util.List;

@Data
public class Apuracao {

    // Getters e Setters
    private int totalVotos;
    private List<Candidato> candidatosPrefeito;
    private List<Candidato> candidatosVereador;

    // padrão
    public Apuracao() {
    }

    // com parâmetros
    public Apuracao(int totalVotos, List<Candidato> candidatosPrefeito, List<Candidato> candidatosVereador) {
        this.totalVotos = totalVotos;
        this.candidatosPrefeito = candidatosPrefeito;
        this.candidatosVereador = candidatosVereador;
    }

    @Override
    public String toString() {
        return "Apuracao{" +
                "totalVotos=" + totalVotos +
                ", candidatosPrefeito=" + candidatosPrefeito +
                ", candidatosVereador=" + candidatosVereador +
                '}';
    }
}