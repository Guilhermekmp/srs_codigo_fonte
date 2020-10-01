package com.basis.srs.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.io.Serializable;

@Entity @Getter @Setter
@Table(name = "sala-equipamento")
public class SalaEquipamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private SalaEquipamentoId id;

    @ManyToOne @MapsId("idEquipamento") @JoinColumn ("id_equipamento")
    private Equipamento equipamento;

    @ManyToOne @MapsId("idSala") @JoinColumn("id_sala")
    private Sala sala;

    @Column(name = "qtd_equipamento")
    private Integer qtd_equipamentos;
}
