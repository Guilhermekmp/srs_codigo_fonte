package com.basis.srs.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) @Column(name = "id")
    private Integer id;

    @Column(name = "nome", length = 120)
    private String nome;

    @Column(name = "cpf", length = 11)
    private String cpf;

    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "telefone", length = 12)
    private String telefone;

    @Column(name = "email", length = 255)
    private String email;

}
