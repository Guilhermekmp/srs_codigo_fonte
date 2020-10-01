package com.basis.srs.dominio;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Getter @Setter @Table(name = "equipamento")
public class Equipamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(length = 255)
    private String name;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(referencedColumnName = "id")
    private Tipo_equipamento tipo_equipamento;
    @Column
    private Double preco_diario;
    @Column
    private Integer obrigatorio;
}
