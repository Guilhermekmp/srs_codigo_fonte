package com.basis.srs.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "tipo_equipamento")
public class TipoEquipamento {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_equipamento")
    @SequenceGenerator(name="sq_equipamento", allocationSize = 1, sequenceName = "sq_equipamento")
    @Column(name = "id")
    private int id;

    @Column(name = "descricao")
    private String descricao;

}
