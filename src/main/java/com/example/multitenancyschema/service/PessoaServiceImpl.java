package com.example.multitenancyschema.service;

import com.example.multitenancyschema.model.Pessoa;
import com.example.multitenancyschema.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class PessoaServiceImpl implements PessoaService {

    private PessoaRepository repository;

    @Override
    @Transactional
    public Pessoa salvar(Pessoa pessoa) {
        return repository.save(pessoa);
    }

}
