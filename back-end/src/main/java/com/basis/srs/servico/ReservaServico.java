package com.basis.srs.servico;

import com.basis.srs.dominio.Reserva;
import com.basis.srs.repositorio.ReservaRepositorio;
import com.basis.srs.servico.dto.ReservaDTO;
import com.basis.srs.servico.mapper.ReservaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservaServico {

    private ReservaRepositorio reservaRepositorio;
    private ReservaMapper reservaMapper;

    public List<ReservaDTO> listar() {
        List<ReservaDTO> lista = reservaMapper.toDto(reservaRepositorio.findAll());
        return lista;
    }

    public ReservaDTO procurar(Integer id) {
        Reserva reserva = reservaRepositorio.findById(id).orElse(null);
        ReservaDTO reservaDTO = reservaMapper.toDto(reserva);
        return reservaDTO;
    }

    public ReservaDTO salvar(ReservaDTO reservaDTO) {
        Reserva reserva = reservaMapper.toEntity(reservaDTO);
        Reserva salvado = reservaRepositorio.save(reserva);
        return reservaMapper.toDto(salvado);
    }

    public void deletar(Integer id) {
        reservaRepositorio.deleteById(id);
    }
}
