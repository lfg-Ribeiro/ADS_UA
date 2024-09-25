package com.dua.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "campeonatos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Campeonato {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String nome;

	    @OneToMany
	    @JoinColumn(name = "campeonato_id") // chave estrangeira para as provas
	    private List<Prova> provas; // Relacionamento com a entidade Prova
}