package com.example.multitenancyschema.controller;

import com.example.multitenancyschema.model.Empresa;
import com.example.multitenancyschema.records.EmpresaRecord;
import com.example.multitenancyschema.service.EmpresaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
@AllArgsConstructor
public class EmpresaController {

    private EmpresaService empresaService;

    @PostMapping("/salvar")
    public Empresa salvar(@RequestBody EmpresaRecord record){
      return empresaService.salvar(new Empresa(record));
    }

    @GetMapping("/lista")
    public List<Empresa> buscar(){
        return empresaService.buscarTodos();
    }


}
