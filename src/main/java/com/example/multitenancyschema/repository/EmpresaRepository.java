package com.example.multitenancyschema.service;

import com.example.multitenancyschema.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
