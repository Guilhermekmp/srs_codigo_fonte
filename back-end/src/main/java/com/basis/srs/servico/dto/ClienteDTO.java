package com.basis.srs.servico.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ClienteDTO {

    private Integer id;
    private String nome;
    private String cpf;
    private String rg;
    private LocalDate dataNascimento;
    private String endereco;
    private String telefone;
    private String email;

}
