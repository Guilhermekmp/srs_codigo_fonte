package com.basis.srs.servico.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ReservaDTO {

    private Date dtIni;
    private Date dtFin;
    private Double total;

}
