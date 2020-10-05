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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "sala")
public class Sala implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_sala")
    @SequenceGenerator(name="sq_sala", allocationSize = 1, sequenceName = "sq_sala")
    @Column(name = "id")
    private Integer id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SalaEquipamento> equipamentos;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_sala")
    private TipoSala tipoSala;

    @Column(name = "capacidade")
    private Integer capacidade;

    @Column(name = "preco_diario")
    private Double precoDiario;

    @Column(name = "disponivel")
    private Integer disponivel;


}
