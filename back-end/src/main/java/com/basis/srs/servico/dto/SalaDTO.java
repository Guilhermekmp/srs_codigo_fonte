package com.basis.srs.servico.dto;

import com.basis.srs.dominio.TipoSala;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class SalaDTO {

    private String descricao;
    private TipoSala tipo_sala;
    private Integer capacidade;
    private Double preco_diario;
    private Integer disponivel;

}
