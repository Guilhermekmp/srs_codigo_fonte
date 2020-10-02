package com.basis.srs.servico;

import com.basis.srs.dominio.Equipamento;
import com.basis.srs.repositorio.EquipamentoRepositorio;
import com.basis.srs.servico.dto.EquipamentoDTO;
import com.basis.srs.servico.mapper.EquipamentoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EquipamentoServico {

    private final EquipamentoRepositorio equipamentoRepositorio;
    private final EquipamentoMapper equipamentoMapper;

    public EquipamentoDTO criar(EquipamentoDTO novoEquipamento){

        Equipamento equip = equipamentoRepositorio.save(equipamentoMapper.toEntity(novoEquipamento));
        EquipamentoDTO equipDTO = equipamentoMapper.toDto(equip);
        return equipDTO;
    }

    public List<EquipamentoDTO> listar(){
        List<EquipamentoDTO> dtoEquips = equipamentoMapper.toDto(equipamentoRepositorio.findAll());
        return dtoEquips;
    }

    public EquipamentoDTO buscar(Integer id){
        EquipamentoDTO dtoEquip = equipamentoMapper.toDto(equipamentoRepositorio.findById(id).orElse(null));
        return dtoEquip;
    }

    public void deletar(Integer id){
         equipamentoRepositorio.deleteById(id);
    }
}
