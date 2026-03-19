package com.tecdes.endereco.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tecdes.endereco.dto.EnderecoDTO;
import com.tecdes.endereco.model.Endereco;
import com.tecdes.endereco.repository.EnderecoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;

    public EnderecoService (EnderecoRepository enderecoRepository){
        this.enderecoRepository = enderecoRepository;
    }

    public EnderecoDTO criarEndereco(EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco();
        endereco.setRua(enderecoDTO.rua());
        endereco.setCidade(enderecoDTO.cidade());
        endereco.setEstado(enderecoDTO.estado());
        endereco.setCEP(enderecoDTO.cep());
        Endereco enderecoSalvo = enderecoRepository.save(endereco);
        return new EnderecoDTO(enderecoSalvo.getId(), enderecoSalvo.getRua(), enderecoSalvo.getCidade(),enderecoSalvo.getEstado(), enderecoSalvo.getCEP());
    }
    
    public List<EnderecoDTO> listarEnderecos(){
        List<Endereco> enderecosEntity = enderecoRepository.findAll();


        return enderecosEntity.stream().map(endereco -> new EnderecoDTO(endereco.getId(), endereco.getRua(), endereco.getCidade(),endereco.getEstado(), endereco.getCEP())).toList();
    }
    //Método para atualizar um aluno (completo) - UPDATE
    public EnderecoDTO atualizarEnderecoPut(Long id, EnderecoDTO enderecoDTO){
        Endereco endereco = enderecoRepository.findById(id).orElseThrow(() -> new RuntimeException("Endereço não encontrado!"));

        endereco.setRua(enderecoDTO.rua());
        endereco.setCidade(enderecoDTO.cidade());
        endereco.setEstado(enderecoDTO.estado());
        endereco.setCEP(enderecoDTO.cep());

        enderecoRepository.save(endereco);

        return new EnderecoDTO(endereco.getId(), endereco.getRua(), endereco.getCidade(),endereco.getEstado(), endereco.getCEP());
    }
     // Método para atualizar um aluno (parcial) - UPDATE
    public EnderecoDTO atualizarEnderecoPatch(Long id,  EnderecoDTO enderecoDTO){
        Endereco endereco = enderecoRepository.findById(id).orElseThrow(() -> new RuntimeException("Endereço não encontrado!"));

        if(enderecoDTO.rua() != null){
            endereco.setRua(enderecoDTO.rua());
        }
        if(enderecoDTO.cidade() != null){
            endereco.setCidade(enderecoDTO.cidade());
        }
        if(enderecoDTO.estado() != null){
            endereco.setEstado(enderecoDTO.estado());
        }
        if(enderecoDTO.cep() != null){
            endereco.setCEP(enderecoDTO.cep());
        }
        enderecoRepository.save(endereco);

        return new EnderecoDTO(endereco.getId(), endereco.getRua(), endereco.getCidade(),endereco.getEstado(), endereco.getCEP());
    }

    // Método para excluir um aluno - DELETE
    public void excluirEndereco(Long id){
        if(!enderecoRepository.existsById(id)){
            throw new EntityNotFoundException("O endereço com id " + id + " não existe!");
        }
        enderecoRepository.deleteById(id);
    }


}
