package com.basis.srs.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity @Getter @Setter
@Table(name = "cliente")
public class Cliente implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(length = 11)
    private String cpf;

    @Column(name = "data_nasc")
    private Date dataNasc;

    @Column
    private String endereco;

    @Column(length = 12)
    private String telefone;

    @Column
    private String email;

}
