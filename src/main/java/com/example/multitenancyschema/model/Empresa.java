package com.example.multitenancyschema.model;

import com.example.multitenancyschema.records.EmpresaRecord;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "EMPRESA")
@RequiredArgsConstructor
public class Empresa implements Serializable {
	
	@Serial
	private static final long serialVersionUID = -6470060645419408897L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo", length = 20, nullable = false)
	private Long codigo;

	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cnpj", unique = true)
	private String cnpj;
	
	@Column(name = "email_administrador")
	private String emailAdministrador;

	public Empresa(Long codigo) {
		this.codigo = codigo;
	}

	public Empresa(EmpresaRecord record) {
		this.nome = record.nome();
		this.cnpj = record.cnpj();
		this.emailAdministrador = record.emailAdministrador();
	}

}
