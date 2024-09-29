package com.example.multitenancyschema.repository;

import com.example.multitenancyschema.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
