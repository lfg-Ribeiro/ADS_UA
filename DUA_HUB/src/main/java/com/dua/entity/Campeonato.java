package com.dua.entity;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "campeonatos")

public class Campeonato {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String nome;

	    @OneToMany
	    @JoinColumn(name = "campeonato_id") // chave estrangeira para as provas
	    private List<Prova> provas; // Relacionamento com a entidade Prova

		public void setId(Long id2) {
			
		}

	}


