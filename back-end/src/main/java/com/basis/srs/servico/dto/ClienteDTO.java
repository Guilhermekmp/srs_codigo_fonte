package com.basis.srs.servico.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

<<<<<<< HEAD
import java.time.LocalDate;
=======
import javax.persistence.Column;
import java.util.Date;
>>>>>>> 2d3b7a30470c9e465dbcf43df90ba1023dc67875

@Getter
@Setter
public class ClienteDTO {

<<<<<<< HEAD
    private Integer id;
    private String nome;
    private String cpf;
    private String rg;
    private LocalDate dataNascimento;
    private String endereco;
    private String telefone;
=======
    private int id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String endereco;
    private String rg;
>>>>>>> 2d3b7a30470c9e465dbcf43df90ba1023dc67875
    private String email;
    private String telefone;


}
