package com.basis.srs.servico.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
public class ClienteDTO {

    private int id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String endereco;
    private String rg;
    private String email;
    private String telefone;


}
