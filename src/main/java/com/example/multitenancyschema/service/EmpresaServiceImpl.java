package com.example.multitenancyschema.service;

import com.example.multitenancyschema.model.Empresa;
import com.example.multitenancyschema.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    @Override
    @Transactional
    public Empresa salvar(Empresa empresa) {
        return repository.save(empresa);
    }

    @Override
    public List<Empresa> buscarTodos() {
        return repository.findAll();
    }

}
