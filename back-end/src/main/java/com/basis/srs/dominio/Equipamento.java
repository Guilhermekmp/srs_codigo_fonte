package com.basis.srs.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Getter @Setter @Table(name = "equipamento")
public class Equipamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(length = 255)
    private String name;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(referencedColumnName = "id")
    private TipoEquipamento tipo_equipamento;
    @Column
    private double preco_diario;
    @Column
    private int obrigatorio;
}
