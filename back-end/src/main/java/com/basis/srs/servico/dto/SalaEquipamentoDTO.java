package com.basis.srs.servico.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class SalaEquipamentoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idSala;

    @NotNull(message = "Id do equipamento é obrigatório")
    private Integer idEquipamento;

    @NotNull(message = "Quantidade é obrigatória")
    private Integer quantidade;
}
