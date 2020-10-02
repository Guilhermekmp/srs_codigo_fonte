package com.basis.srs.servico.dto;

import com.basis.srs.dominio.Cliente;
import com.basis.srs.dominio.Sala;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class ReservaDTO {

    private int id;
    private ClienteDTO cliente;
    private SalaDTO sala;
    private Double total;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
}
