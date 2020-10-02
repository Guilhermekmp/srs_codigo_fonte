package com.basis.srs.servico.dto;

import com.basis.srs.dominio.TipoEquipamento;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class EquipamentoDTO {
    private String name;
    private TipoEquipamento tipo_equipamento;
    private double reco_diario;
    private int obrigatorio;
}
