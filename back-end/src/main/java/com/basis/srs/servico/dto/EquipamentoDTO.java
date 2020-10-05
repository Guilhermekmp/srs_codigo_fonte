package com.basis.srs.servico.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EquipamentoDTO {

    private Integer id;
    private String nome;
    private DominioFixoDTO tipoEquipamento;
    private Double precoDiario;
    private Integer obrigatorio;
}
