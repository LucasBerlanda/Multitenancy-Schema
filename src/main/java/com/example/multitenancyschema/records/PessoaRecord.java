package com.example.multitenancyschema.records;

public record PessoaRecord(
        String nome,
        String cpf,
        String email
) {}
