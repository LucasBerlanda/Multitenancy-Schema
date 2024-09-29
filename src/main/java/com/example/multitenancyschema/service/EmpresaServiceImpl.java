package com.example.multitenancyschema.service;

import com.example.multitenancyschema.FlywayComponent;
import com.example.multitenancyschema.model.Empresa;
import com.example.multitenancyschema.repository.EmpresaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Service
@AllArgsConstructor
public class EmpresaServiceImpl implements EmpresaService {

    private EmpresaRepository repository;
    private FlywayComponent flywayComponent;
    private DataSource dataSource;

    @Override
    @Transactional
    public Empresa salvar(Empresa empresa) {
        Empresa empresaSalva = repository.save(empresa);
        flywayComponent.executeMigrationsForSchema(String.valueOf(empresaSalva.getCodigo()), dataSource);
        return empresaSalva;
    }

    @Override
    public List<Empresa> buscarTodos() {
        return repository.findAll();
    }

}
