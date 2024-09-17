package urna.urna.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dataHora; // Data e hora da votação

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidato_prefeito_id", nullable = false)
    private Candidato candidatoPrefeito;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidato_vereador_id", nullable = false)
    private Candidato candidatoVereador;

    @Column(nullable = false)
    private String hash;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Candidato getCandidatoPrefeito() {
        return candidatoPrefeito;
    }

    public void setCandidatoPrefeito(Candidato candidatoPrefeito) {
        this.candidatoPrefeito = candidatoPrefeito;
    }

    public Candidato getCandidatoVereador() {
        return candidatoVereador;
    }

    public void setCandidatoVereador(Candidato candidatoVereador) {
        this.candidatoVereador = candidatoVereador;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
