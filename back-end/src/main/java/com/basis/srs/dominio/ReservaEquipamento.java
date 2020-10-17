package com.basis.srs.dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "sala_equipamento")
public class ReservaEquipamento implements Serializable{

    @EmbeddedId
    private ReservaEquipamentoId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idEquipamento")
    @JoinColumn (name = "id_equipamento")
    private Equipamento equipamento;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("idReserva") @JoinColumn(name = "id_reserva")
    private Reserva reserva;

    @Column(name = "quantidade")
    private Integer quantidade;
}
