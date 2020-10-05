package com.basis.srs.servico;

import com.basis.srs.dominio.Sala;
import com.basis.srs.dominio.SalaEquipamento;
import com.basis.srs.repositorio.SalaRepositorio;
import com.basis.srs.repositorio.SalaEquipamentoRepositorio;
import com.basis.srs.servico.dto.SalaDTO;
import com.basis.srs.servico.mapper.SalaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SalaServico {

    private final SalaRepositorio salaRepositorio;
    private final SalaEquipamentoRepositorio salaEquipamentoRepositorio;
    private final SalaMapper salaMapper;

    public List<SalaDTO> listar(){
        List<SalaDTO> salas = salaMapper.toDto(salaRepositorio.findAll());
        return salas;
    }

    public SalaDTO buscar(Integer id){
        Sala sala = salaRepositorio.findById(id).orElse(null);
        SalaDTO salaDTO = salaMapper.toDto(sala);
        return salaDTO;
    }

    public SalaDTO criar(SalaDTO sala){
        Sala novaSala = salaRepositorio.save(salaMapper.toEntity(sala));
        List<SalaEquipamento> equipamentos = novaSala.getEquipamentos();
        novaSala.setEquipamentos(new ArrayList<>());
        equipamentos.forEach(equipamento ->{
            equipamento.setSala(novaSala);
            equipamento.getId().setIdSala(novaSala.getId());
        });
        salaEquipamentoRepositorio.saveAll(equipamentos);
        SalaDTO salaDTO = salaMapper.toDto(novaSala);
        return salaDTO;
    }

    public void deletar(Integer id){
        salaRepositorio.deleteById(id);
    }
}
