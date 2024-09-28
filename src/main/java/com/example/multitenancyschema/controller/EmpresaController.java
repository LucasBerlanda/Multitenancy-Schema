package br.com.academia.controller;

import br.com.academia.dto.EmpresaRecord;
import br.com.academia.model.Contato;
import br.com.academia.model.Empresa;
import br.com.academia.repository.ContatoRepository;
import br.com.academia.service.EmpresaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
@AllArgsConstructor
public class EmpresaController {

    private EmpresaService empresaService;
    private ContatoRepository contatoRepository;

    @PostMapping("/salvar")
    public Empresa salvar(@RequestBody EmpresaRecord record){
      return empresaService.salvar(new Empresa(record));
    }

    @GetMapping("/lista")
    public List<Empresa> buscar(){
        return empresaService.buscarTodos();
    }


    @PostMapping("/salvar-contato")
    public Contato salvarContatoTest(@RequestBody Contato contato){
        return contatoRepository.save(contato);
    }

    @GetMapping("/buscar-contatos")
    public List<Contato> buscarContatos(){
        return contatoRepository.findAll();
    }
}
