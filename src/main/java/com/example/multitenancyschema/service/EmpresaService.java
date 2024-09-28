package com.example.multitenancyschema.service;

import com.example.multitenancyschema.model.Empresa;

import java.util.List;

public interface EmpresaService {

    Empresa salvar(Empresa empresa);

    List<Empresa> buscarTodos();
}
