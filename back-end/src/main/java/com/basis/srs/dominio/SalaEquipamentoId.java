package com.basis.srs.dominio;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SalaEquipamentoId implements Serializable {
    private Integer idSala;
    private Integer idEquipamento;
}
