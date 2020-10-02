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

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_cliente")
    @SequenceGenerator(name="sq_cliente", allocationSize = 1, sequenceName = "sq_cliente")
    @Column(name = "id")
    private int id;

    @Column( name = "nome")
    private String nome;

    @Column(name ="cpf")
    private String cpf;

    @Column(name = "data_nasc")
    private Date dataNasc;

    @Column(name ="endereco")
    private String endereco;

    @Column(name ="rg")
    private String rg;

    @Column(name ="email")
    private String email;

}
