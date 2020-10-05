package com.basis.srs.servico.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReservaDTO {

    private Integer id;
    private Integer idCliente;
    private Integer idSala;
    private Double total;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
}
