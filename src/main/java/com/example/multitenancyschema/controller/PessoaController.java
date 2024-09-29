package com.example.multitenancyschema.controller;

import com.example.multitenancyschema.model.Pessoa;
import com.example.multitenancyschema.records.PessoaRecord;
import com.example.multitenancyschema.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
@AllArgsConstructor
public class PessoaController {

    private PessoaService pessoaService;

    @PostMapping("/salvar")
    public Pessoa salvar(@RequestBody PessoaRecord record){
      return pessoaService.salvar(new Pessoa(record));
    }


}
