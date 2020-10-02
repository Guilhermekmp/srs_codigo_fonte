package com.basis.srs.servico.dto;

import com.basis.srs.dominio.TipoEquipamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EquipamentoDTO {

    private Integer id;
    private String name;
    private DominioFixoDTO tipo_equipamento;
    private Double preco_diario;
    private Integer obrigatorio;
}
