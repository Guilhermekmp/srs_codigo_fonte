package com.basis.srs.servico.dto;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservaEquipamentoDTO {
    private static final long serialVersionUID = 1L;

    private Integer idReserva;

    @NotNull(message = "Id do equipamento é obrigatório")
    private Integer idEquipamento;

    @NotNull(message = "Quantidade é obrigatória")
    private Integer quantidade;
}
