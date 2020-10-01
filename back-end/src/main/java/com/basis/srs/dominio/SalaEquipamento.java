package com.basis.srs.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.io.Serializable;

@Entity @Getter @Setter
@Table(name = "sala_equipamento")
public class SalaEquipamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private SalaEquipamentoId id;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @MapsId("idEquipamento") @JoinColumn (name = "id_equipamento")
    private Equipamento equipamento;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @MapsId("idSala") @JoinColumn(name = "id_sala")
    private Sala sala;

    @Column(name = "qtd_equipamento")
    private Integer qtd_equipamentos;
}
