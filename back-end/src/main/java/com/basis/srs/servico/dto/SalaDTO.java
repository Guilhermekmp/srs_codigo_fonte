package com.basis.srs.servico.dto;

import com.basis.srs.dominio.TipoSala;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalaDTO {

    private Integer id;
    private String descricao;
    private DominioFixoDTO tipo_sala;
    private Integer capacidade;
    private Double preco_diario;
    private Integer disponivel;

}
