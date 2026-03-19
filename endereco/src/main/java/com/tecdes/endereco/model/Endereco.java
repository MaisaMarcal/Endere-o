package com.tecdes.endereco.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "endereço")  
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )

    private Long id;
    private String rua;
    private String cidade;
    private String estado;
    private String cep;


public Endereco(Long id, String rua, String cidade, String estado, String cep) {
    this.id= id;
    this.rua =rua;
    this.cidade = cidade;
    this.estado = estado;
    this.cep = cep;

}
    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;

    }
    public String getCEP() {
        return cep;
    }

    public void setCEP(String cep) {
        this.cep = cep;
    }

    
}
