package com.tecdes.endereco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecdes.endereco.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
