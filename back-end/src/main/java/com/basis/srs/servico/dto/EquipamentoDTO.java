package com.basis.srs.servico.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class EquipamentoDTO {

    private Integer id;

    @NotNull(message = "Campo não pode ser nulo")
    @Size(max = 255)
    private String nome;

    @NotNull(message = "Campo não deve ser nulo")
    @Min(1)
    @Max(3)
    private Integer idTipoEquipamento;

    @NotNull(message = "Campo não deve ser nulo")
    private Double precoDiario;

}
