package com.basis.srs.servico;

import com.basis.srs.dominio.Sala;
import com.basis.srs.repositorio.SalaRepositorio;
import com.basis.srs.servico.dto.SalaDTO;
import com.basis.srs.servico.mapper.SalaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SalaServico {

    private SalaRepositorio salaRepositorio;
    private SalaMapper salaMapper;

    public List<SalaDTO> listar(){
        List<SalaDTO> salas = salaMapper.toDto(salaRepositorio.findAll());
        return salas;
    }

    public SalaDTO buscar(Integer id){
        Sala sala = salaRepositorio.findById(id).orElse(null);
        SalaDTO salaDTO = salaMapper.toDto(sala);
        return salaDTO;
    }

    public SalaDTO criar(Sala sala){
        Sala novaSala = salaRepositorio.save(sala);
        SalaDTO salaDTO = salaMapper.toDto(novaSala);
        return salaDTO;
    }

    public void deletar(Integer id){
        salaRepositorio.deleteById(id);
    }
}
