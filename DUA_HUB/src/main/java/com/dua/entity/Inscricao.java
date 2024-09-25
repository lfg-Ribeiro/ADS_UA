package com.dua.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "inscricoes")
@Data
public class Inscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único da inscrição

    @ManyToOne
    @JoinColumn(name = "participante_id", nullable = false)
    private Participante participante; // Referência ao participante inscrito

    @ManyToOne
    @JoinColumn(name = "prova_id", nullable = false)
    private Prova prova; // Referência à prova na qual o participante está inscrito

    private LocalDateTime dataInscricao; // Data e hora da inscrição

    private String status; // Status da inscrição (ex.: confirmada, pendente)
}
