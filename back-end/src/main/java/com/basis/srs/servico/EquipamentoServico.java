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
            if (equipamento.getNome().equals(novoEquipamento.getNome())) {
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

    public void deletar(Integer id){
        for (Equipamento equipamento:equipamentoRepositorio.findAll()) {
            if (equipamento.getId()== id && equipamento.getObrigatorio()==0){
                    for (Sala sala:salaRepositorio.findAll()){
                        for (SalaEquipamento salaEquipamento : sala.getEquipamentos()) {
                            if(salaEquipamento.getEquipamento().getId()==id){
                                throw new RegraNegocioException("Equipamento está sendo utilizado em uma sala.");
                        }else{
                                equipamentoRepositorio.deleteById(id);
                            }
                        }
                    }

            }else {
                throw new RegraNegocioException("Equipamento é obrigatório");
                }
            }
        }

}



