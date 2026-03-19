package com.tecdes.endereco.service;

import org.springframework.stereotype.Service;

import com.tecdes.endereco.dto.EnderecoDTO;
import com.tecdes.endereco.repository.EnderecoRepository;

@Service
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;

    public EnderecoService (EnderecoRepository enderecoRepository){
        this.enderecoRepository = enderecoRepository;
    }

    public EnderecoDTO criarAluno(EnderecoDTO enderecoDTO) {
        Endereco endereco = new endereco();
        aluno.setNome(alunoDTO.nome());
        aluno.setEmail(alunoDTO.email());
        Aluno alunoSalvo = alunoRepository.save(aluno);
        return new AlunoDTO(alunoSalvo.getId(), alunoSalvo.getNome(), alunoSalvo.getEmail());
    }
    
}
