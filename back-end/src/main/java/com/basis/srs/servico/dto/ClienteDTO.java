package com.basis.srs.servico.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ClienteDTO {

    private Integer id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String endereco;
    private String rg;
    private String email;
    private String telefone;


}
