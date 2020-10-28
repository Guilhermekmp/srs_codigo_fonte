package com.basis.srs.servico;

import com.basis.srs.dominio.Equipamento;
import com.basis.srs.dominio.Sala;
import com.basis.srs.repositorio.EquipamentoRepositorio;
import com.basis.srs.repositorio.SalaRepositorio;
import com.basis.srs.servico.dto.EquipamentoDTO;
import com.basis.srs.servico.dto.ReservaDTO;
import com.basis.srs.servico.dto.SalaDTO;
import com.basis.srs.servico.exception.RegraNegocioException;
import com.basis.srs.servico.exception.RegraNegocioExceptionNotFound;
import com.basis.srs.servico.mapper.EquipamentoMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class EquipamentoServico {

    private final EquipamentoRepositorio equipamentoRepositorio;
    private final EquipamentoMapper equipamentoMapper;
    private final SalaRepositorio salaRepositorio;

    public EquipamentoDTO criar(EquipamentoDTO novoEquipamento) {
        if(novoEquipamento.getId()!=null){
            for (Equipamento equipamento: equipamentoRepositorio.findAll()) {
                if (equipamento.getNome().equals(novoEquipamento.getNome())
                        && equipamento.getTipoEquipamento().getId().equals(novoEquipamento.getIdTipoEquipamento())) {
                    throw new RegraNegocioException("Incompatibilidade com outro equipamento, por favor verifique o equipamento de id" + " " + equipamento.getId());
                }
            }
            Equipamento equip = equipamentoRepositorio.save(equipamentoMapper.toEntity(novoEquipamento));
            EquipamentoDTO equipDTO = equipamentoMapper.toDto(equip);
            return equipDTO;
        }else {
            for (Equipamento equipamento : equipamentoRepositorio.findAll()) {
                if (equipamento.getNome().equals(novoEquipamento.getNome())
                        && equipamento.getPrecoDiario().equals(novoEquipamento.getPrecoDiario())
                        && equipamento.getTipoEquipamento().getId().equals(novoEquipamento.getIdTipoEquipamento())) {
                    throw new RegraNegocioException("Equipamento já existe!");
                }
            }
            Equipamento equip = equipamentoRepositorio.save(equipamentoMapper.toEntity(novoEquipamento));
            EquipamentoDTO equipDTO = equipamentoMapper.toDto(equip);
            return equipDTO;
        }
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

        equipamentoRepositorio.deleteById(id);
    }
}




