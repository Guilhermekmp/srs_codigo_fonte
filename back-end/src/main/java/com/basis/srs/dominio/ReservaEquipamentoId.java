package com.basis.srs.dominio;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class ReservaEquipamentoId implements Serializable {

    private Integer idReserva;

    private Integer idEquipamento;

}
