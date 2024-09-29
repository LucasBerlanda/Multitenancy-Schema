package com.example.multitenancyschema.model;

import com.example.multitenancyschema.records.PessoaRecord;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "PESSOA")
@RequiredArgsConstructor
public class Pessoa implements Serializable {

	@Serial
	private static final long serialVersionUID = -6470060645419408897L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo", length = 20, nullable = false)
	private Long codigo;

	@Column(name = "nome")
	private String nome;

	@Column(name = "cpf", unique = true)
	private String cpf;

	@Column(name = "email")
	private String email;

	public Pessoa(PessoaRecord record) {
		this.nome = record.nome();
		this.cpf = record.cpf();
		this.email = record.email();
	}
}
