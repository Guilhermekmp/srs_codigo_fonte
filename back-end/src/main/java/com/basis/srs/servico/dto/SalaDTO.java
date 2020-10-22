package com.basis.srs.servico.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class SalaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotNull(message = "Descrição é obrigatória")
    private String descricao;

    @NotNull(message = "Equipamentos são obrigatórios")
    private List<SalaEquipamentoDTO> equipamentos;

    @NotNull(message = "Tipo da sala é obrigatório")
    @Min(1)
    @Max(5)
    private Integer idTipoSala;

    @NotNull(message = "Capacidade é obrigatória")
    private Integer capacidade;

    @NotNull(message = "Preço da diária é obrigatório")
    private Double precoDiario;

}
