package com.basis.srs.servico.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class SalaDTO {

    private Integer id;
    private String descricao;
    private ArrayList<SalaEquipamentoDTO> equipamentos;
    private Integer idTipoSala;
    private Integer capacidade;
    private Double precoDiario;
    private Integer disponivel;

}
