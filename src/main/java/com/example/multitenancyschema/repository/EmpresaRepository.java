package com.example.multitenancyschema.repository;

import com.example.multitenancyschema.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
