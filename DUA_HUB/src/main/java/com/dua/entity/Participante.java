package com.dua.entity;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;
import java.util.List;

@Data
@Entity
@Table(name = "participantes")
public class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @CPF
    private String cpf;

    private Integer idade;

    private String telefone;
    
    @ManyToMany(mappedBy = "participantes") //um participante pode estar em varias provas
    private List<Prova> provas;

    @ManyToOne
    @JoinColumn(name = "equipe_id") //chave estrangeira pra equipe
    private Equipe equipe;

}