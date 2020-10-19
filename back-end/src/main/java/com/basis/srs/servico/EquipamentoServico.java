package com.basis.srs.servico;

import com.basis.srs.dominio.Equipamento;
import com.basis.srs.dominio.Sala;
import com.basis.srs.dominio.SalaEquipamento;
import com.basis.srs.repositorio.EquipamentoRepositorio;
import com.basis.srs.repositorio.SalaRepositorio;
import com.basis.srs.servico.dto.EquipamentoDTO;
import com.basis.srs.servico.exception.RegraNegocioException;
import com.basis.srs.servico.exception.RegraNegocioExceptionNotFound;
import com.basis.srs.servico.mapper.EquipamentoMapper;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import java.lang.reflect.Array;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EquipamentoServico {

    private final EquipamentoRepositorio equipamentoRepositorio;
    private final EquipamentoMapper equipamentoMapper;
    private final SalaRepositorio salaRepositorio;

    public EquipamentoDTO criar(EquipamentoDTO novoEquipamento) {
        for (Equipamento equipamento : equipamentoRepositorio.findAll()) {
            if (equipamento.equals(novoEquipamento)) {
                throw new RegraNegocioException("Equipamento já existe");
            }
        }
        Equipamento equip = equipamentoRepositorio.save(equipamentoMapper.toEntity(novoEquipamento));
        EquipamentoDTO equipDTO = equipamentoMapper.toDto(equip);
        return equipDTO;
    }

    public List<EquipamentoDTO> listar(){
        List<EquipamentoDTO> dtoEquips = equipamentoMapper.toDto(equipamentoRepositorio.findAll());
        return dtoEquips;
    }

    public EquipamentoDTO buscar(Integer id){
        EquipamentoDTO dtoEquip = equipamentoMapper.toDto(equipamentoRepositorio.findById(id)
                .orElseThrow(()->new RegraNegocioExceptionNotFound("Equipamento não encontrado.")));
        return dtoEquip;
    }

    public void deletar(Integer id) {
        EquipamentoDTO equipamento = buscar(id);
        List<Sala> salas = salaRepositorio.findAll();
        if(salas.contains(equipamento)) {
            throw new RegraNegocioException("Equipamento está sendo utilizado.");
        }
        else {
            equipamentoRepositorio.deleteById(id);
        }
    }
}



