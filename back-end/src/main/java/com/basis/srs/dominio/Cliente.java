package com.basis.srs.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "cliente")
public class Cliente implements Serializable {

    @Id
    private int id;

    @Column(length = 255, name = "nome")
    private String nome;

    @Column(length = 11)
    private String cpf;

    @Column(name = "data_nasc")
    private Date dataNasc;

    @Column(length = 255)
    private String endereco;

    @Column(length = 12)
    private String telefone;

    @Column(length = 255)
    private String email;

}
