package com.basis.srs.servico.mapper;

import com.basis.srs.dominio.Reserva;
import com.basis.srs.servico.dto.ReservaDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ReservaMapper extends EntityMapper<ReservaDTO, Reserva> {
}
