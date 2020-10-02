package com.basis.srs.servico.dto;

import com.basis.srs.dominio.Equipamento;
import com.basis.srs.dominio.Sala;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SalaEquipamentoDTO {

    private Equipamento equipamento;

    private Sala sala;

    private Integer qtd_equipamentos;
}
