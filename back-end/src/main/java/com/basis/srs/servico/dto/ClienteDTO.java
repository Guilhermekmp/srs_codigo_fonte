package com.basis.srs.servico.dto;

import java.time.LocalDate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {

    private Integer id;

    @NotNull
    @Size(max = 120)
    private String nome;

    @NotNull
    @Size(max = 11, min = 11)
    @NotBlank
    private String cpf;

    @NotNull
    @Past
    private LocalDate dataNascimento;

    @NotNull
    private String endereco;

    @NotNull
    @Size(max = 7, min = 7)
    @NotBlank
    private String rg;

    @Email
    @NotNull
    @Size(max = 255)
    private String email;

    @NotNull
    @Size(max = 12, min = 12)
    private String telefone;


}
