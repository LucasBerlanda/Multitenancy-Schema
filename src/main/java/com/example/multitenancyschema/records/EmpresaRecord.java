package com.example.multitenancyschema.records;

public record EmpresaRecord(
        String nome,
        String cnpj,
        String emailAdministrador
) {}
