package com.basis.srs.servico.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class DominioFixoDTO {

    private Integer id;

    @NotNull(message = "Descrição é obrigatória")
    private String descricao;
}
