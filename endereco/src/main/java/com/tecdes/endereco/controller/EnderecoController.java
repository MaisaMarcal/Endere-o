package com.tecdes.endereco.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tecdes.endereco.dto.EnderecoDTO;
import com.tecdes.endereco.service.EnderecoService;


@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    

    private final EnderecoService enderecoService;

    // Injeção de dependência via construtor
    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;


    }

      // CREATE - Endpoint (rota) para criar um aluno retornando um responseEntity
    @PostMapping("/salvar")
    public ResponseEntity<EnderecoDTO> criarEndereco(@RequestBody EnderecoDTO enderecoDTO) {

        EnderecoDTO enderecoCriado = enderecoService.criarEndereco(enderecoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoCriado);
    }

    // RESTORE - Endpoint (rota para buscar todos os alunos)
    @GetMapping("/listar")
    public ResponseEntity<List<EnderecoDTO>> listarEnderecos() {
        List<EnderecoDTO> enderecos = enderecoService.listarEnderecos();

        if(enderecos.isEmpty()){
            return ResponseEntity.noContent().build();
        } 

        return ResponseEntity.ok(enderecos);



    }
     // UPDATE - Endpoint (rota) para atualizar um aluno
    @PutMapping("put/{id}")
    public ResponseEntity<EnderecoDTO> atualizarEnderecoPut(@PathVariable Long id, @RequestBody EnderecoDTO enderecoDTO) {
       EnderecoDTO enderecoAtualizado = enderecoService.atualizarEnderecoPut(id, enderecoDTO);
        
        return ResponseEntity.ok(enderecoAtualizado);
    }

    // UPDATE - Endpoint (rota) para atualizar um aluno (parcial)
    @PatchMapping("patch/{id}")
    public ResponseEntity<EnderecoDTO> atualizarAlunoPatch(@PathVariable Long id, @RequestBody EnderecoDTO enderecoDTO) {
       EnderecoDTO enderecoAtualizado = enderecoService.atualizarEnderecoPatch(id, enderecoDTO);
        
        return ResponseEntity.ok(enderecoAtualizado);
    }

    // DELETE - Endpoint (rota) para excluir um aluno
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEndereco(@PathVariable Long id){
        
        enderecoService.excluirEndereco(id);

        return ResponseEntity.noContent().build();
    }

}
