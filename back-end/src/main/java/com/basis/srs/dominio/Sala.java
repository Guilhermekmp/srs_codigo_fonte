package com.basis.srs.dominio;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Data @Table(name = "equipamento")
public class Sala implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 255)
    private String name;
    @ForeignKey(name = )
    private int id_tipo_equipamento;

}
