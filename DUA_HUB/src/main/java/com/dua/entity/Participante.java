package com.dua.entity;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "participantes")
@Data
public class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    //@CPF
    private String cpf;

    private Integer idade;

    private String telefone;
    
    //@ManyToMany(mappedBy = "participantes")//um participante pode estar em varias provas
    //private List<Prova> provas;

    @ManyToOne
    @JoinColumn(name = "equipe_id")//chave estrangeira pra equipe
    private Equipe equipe;

}