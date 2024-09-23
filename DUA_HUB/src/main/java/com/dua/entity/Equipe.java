package com.dua.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "equipes")
@Data
public class Equipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	// Relacionamento bidirecional com Participante
	@OneToMany(mappedBy = "equipe", cascade = CascadeType.ALL) // Cascade opcional, para salvar/deletar participantes junto com a equipe
	private List<Participante> participantes;
}