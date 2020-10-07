package com.basis.srs.servico.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Getter
@Setter
public class SalaDTO {

    private Integer id;

    @NotNull
    @NotBlank
    private String descricao;

    @NotNull
    private ArrayList<SalaEquipamentoDTO> equipamentos;

    @NotNull
    @Min(1)
    @Max(4)
    private Integer idTipoSala;

    @NotNull
    private Integer capacidade;

    @NotNull
    @Min(0)
    private Double precoDiario;

    @NotNull
    @Min(0)
    @Max(1)
    private Integer disponivel;

}
