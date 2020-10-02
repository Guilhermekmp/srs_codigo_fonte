package com.basis.srs.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

<<<<<<< HEAD
@Entity @Getter @Setter @Table(name = "tipo_equipamento")
public class TipoEquipamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(length = 255)
=======
@Entity
@Getter
@Setter
@Table(name = "tipo_equipamento")
public class TipoEquipamento implements Serializable{

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_equipamento")
    @SequenceGenerator(name="sq_equipamento", allocationSize = 1, sequenceName = "sq_equipamento")
    @Column(name = "id")
    private int id;

    @Column(name = "descricao")
>>>>>>> 2d3b7a30470c9e465dbcf43df90ba1023dc67875
    private String descricao;

}
