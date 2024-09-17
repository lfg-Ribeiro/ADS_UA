package urna.urna.entity;

import urna.urna.entity.Candidato;
import java.util.List;

public class Apuracao {

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

    // Getters e Setters
    public int getTotalVotos() {
        return totalVotos;
    }

    public void setTotalVotos(int totalVotos) {
        this.totalVotos = totalVotos;
    }

    public List<Candidato> getCandidatosPrefeito() {
        return candidatosPrefeito;
    }

    public void setCandidatosPrefeito(List<Candidato> candidatosPrefeito) {
        this.candidatosPrefeito = candidatosPrefeito;
    }

    public List<Candidato> getCandidatosVereador() {
        return candidatosVereador;
    }

    public void setCandidatosVereador(List<Candidato> candidatosVereador) {
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