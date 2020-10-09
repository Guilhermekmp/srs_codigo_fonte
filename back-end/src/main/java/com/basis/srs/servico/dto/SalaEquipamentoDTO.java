package com.basis.srs.servico.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SalaEquipamentoDTO {

    @NotNull(message = "Id da sala é obrigatório")
    private Integer idSala;

    @NotNull(message = "Id do equipamento é obrigatório")
    private Integer idEquipamento;

    @NotNull(message = "Quantidade é obrigatória")
    private Integer quantidade;
}
