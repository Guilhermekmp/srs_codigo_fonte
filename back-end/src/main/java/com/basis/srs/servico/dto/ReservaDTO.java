package com.basis.srs.servico.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotNull
    private Integer idCliente;

    @NotNull
    private Integer idSala;

    @NotNull
    private Double total;

    @NotNull
    @FutureOrPresent
    private LocalDateTime dataInicio;
    
    @NotNull
    @Future
    private LocalDateTime dataFim;

    @NotNull
    private List<ReservaEquipamentoDTO> equipamentos;
}
