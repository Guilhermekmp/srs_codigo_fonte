package com.basis.srs.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity @Getter @Setter @Table(name = "equipamento")
public class Equipamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column
    private String name;

    @OneToOne
    @JoinColumn(name = "id_tipo_equipamento",referencedColumnName = "id")
    private TipoEquipamento tipoEquipamento;

    @Column(name = "preco_diario")
    private double precoDiario;

    @Column(name = "obrigatorio")
    private int obrigatorio;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<SalaEquipamento> salaEquipamentos;
}
