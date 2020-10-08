package com.basis.srs.servico.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Getter
@Setter
public class SalaDTO {

    private Integer id;

    @NotNull(message = "Descrição é obrigatória")
    private String descricao;

    @NotNull(message = "Equipamentos são é obrigatórios")
    private ArrayList<SalaEquipamentoDTO> equipamentos;

    @NotNull(message = "Tipo da sala é obrigatório")
    @Min(1)
    @Max(5)
    private Integer idTipoSala;

    @NotNull(message = "Capacidade é obrigatória")
    private Integer capacidade;

    @NotNull(message = "Preço da diária é obrigatório")
    private Double precoDiario;

    @NotNull(message = "Disponibilidade é é obrigatória")
    @Min(0)
    @Max(1)
    private Integer disponivel;

}
