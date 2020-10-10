package com.basis.srs.servico;

import com.basis.srs.dominio.Reserva;
import com.basis.srs.repositorio.ReservaRepositorio;
import com.basis.srs.servico.dto.ReservaDTO;
import com.basis.srs.servico.exception.RegraNegocioException;
import com.basis.srs.servico.exception.RegraNegocioExceptionNotFound;
import com.basis.srs.servico.mapper.ReservaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservaServico {

    private final ReservaRepositorio reservaRepositorio;
    private final ReservaMapper reservaMapper;

    public List<ReservaDTO> listar(){
        List<ReservaDTO> reserva = reservaMapper.toDto(reservaRepositorio.findAll());
        return reserva;
    }

    public ReservaDTO buscar(Integer id){
        Reserva reserva = reservaRepositorio.findById(id)
                .orElseThrow(()-> new RegraNegocioExceptionNotFound("Reserva não encontrada"));
        ReservaDTO reservaDTO = reservaMapper.toDto(reserva);
        return reservaDTO;
    }

    public ReservaDTO criar(ReservaDTO reserva){
        if (reserva.getId() != null) {
            buscar(reserva.getId());
        }else{
            for (Reserva reservaLista : reservaRepositorio.findAll()) {
                if (reservaLista.getSala().getId().equals(reserva.getIdSala())
                        && (reservaLista.getDataInicio().equals(reserva.getDataInicio())
                        || reservaLista.getDataFim().equals(reserva.getDataFim())
                        || reservaLista.getDataFim().isAfter(reserva.getDataInicio()))) {
                    throw new RegraNegocioException("Reserva ja existe para esse periodo");
                }
            }
        }
        Reserva novaReserva = reservaMapper.toEntity(reserva);
        novaReserva = reservaRepositorio.save(novaReserva);
        ReservaDTO reservaDTO = reservaMapper.toDto(novaReserva);
        return reservaDTO;
    }

    public void deletar(Integer id){
        buscar(id);
        reservaRepositorio.deleteById(id);
    }

}
