package com.basis.srs.servico;

import com.basis.srs.dominio.Reserva;
import com.basis.srs.dominio.Reserva;
import com.basis.srs.repositorio.ReservaRepositorio;
import com.basis.srs.servico.dto.ReservaDTO;
import com.basis.srs.servico.mapper.ReservaMapper;
import com.basis.srs.servico.mapper.SalaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        Reserva reserva = reservaRepositorio.findById(id).orElse(null);
        ReservaDTO reservaDTO = reservaMapper.toDto(reserva);
        return reservaDTO;
    }

    public ReservaDTO criar(ReservaDTO reserva){
        Reserva novaReserva = reservaRepositorio.save(reservaMapper.toEntity(reserva));
        ReservaDTO reservaDTO = reservaMapper.toDto(novaReserva);
        return reservaDTO;
    }

    public void deletar(Integer id){
        reservaRepositorio.deleteById(id);
    }

}
