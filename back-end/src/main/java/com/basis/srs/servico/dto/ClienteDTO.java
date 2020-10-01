package com.basis.srs.servico.dto;

import lombok.Getter;

@Getter
public class ClienteDTO {

    private String nome;
    private String endereco;
    private String email;

    public ClienteDTO(String nome, String endereco, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
    }
}
