package com.basis.srs.servico.dto;

import com.basis.srs.dominio.Tipo_equipamento;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class EquipamentoDTO {
    private String name;
    private Tipo_equipamento tipo_equipamento;
    private double reco_diario;
    private int obrigatorio;
}
