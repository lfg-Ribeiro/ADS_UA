package com.dua.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "participantes")
@Data
public class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cpf;

    @ManyToMany(mappedBy = "participantes")
    private List<Equipe> equipes;

    public Participante() {}

    public Participante(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
}