package com.basis.srs.servico.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class ReservaDTO {

    private Date dtIni;
    private Date dtFin;
    private double total;

    public ReservaDTO(Date dtIni, Date dtFin, double total) {
        this.dtIni = dtIni;
        this.dtFin = dtFin;
        this.total = total;
    }
}
