package com.basis.srs.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "equipamento")
public class Equipamento {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_equipamento")
    @SequenceGenerator(name="sq_equipamento", allocationSize = 1, sequenceName = "sq_equipamento")
    @Column(name = "id")
    private int id;

    @Column(name = "nome")
    private String nome;

    @OneToOne
    @JoinColumn(name = "id_tipo_equipamento",referencedColumnName = "id")
    private TipoEquipamento tipoEquipamento;

    @Column(name = "preco_diario")
    private Double precoDiario;

    @Column(name = "obrigatorio")
    private Integer obrigatorio;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SalaEquipamento> salas;
}
