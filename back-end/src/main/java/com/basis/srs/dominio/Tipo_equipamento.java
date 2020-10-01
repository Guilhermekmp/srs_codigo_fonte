package com.basis.srs.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Getter @Setter @Table(name = "tipo_equipamento")
public class Tipo_equipamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(length = 255)
    private String descricao;

}
