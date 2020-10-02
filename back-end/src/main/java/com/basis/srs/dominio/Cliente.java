package com.basis.srs.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "cliente")
public class Cliente implements Serializable{

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_cliente")
    @SequenceGenerator(name="sq_cliente", allocationSize = 1, sequenceName = "sq_cliente")
    @Column(name = "id")
    private int id;

<<<<<<< HEAD
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_cliente")
    @SequenceGenerator(name = "sq_cliente", allocationSize = 1, sequenceName = "sq_cliente")
    @Column(name = "id")
    private Integer id;

=======
>>>>>>> 2d3b7a30470c9e465dbcf43df90ba1023dc67875
    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name= "rg")
    private String rg;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "endereco")
    private String endereco;

<<<<<<< HEAD
    @Column(name = "telefone")
    private String telefone;
=======
    @Column(name = "rg")
    private String rg;
>>>>>>> 2d3b7a30470c9e465dbcf43df90ba1023dc67875

    @Column(name = "email")
    private String email;

    @Column
    private String telefone;

}
