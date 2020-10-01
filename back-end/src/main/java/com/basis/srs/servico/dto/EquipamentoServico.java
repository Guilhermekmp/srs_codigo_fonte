package com.basis.srs.servico.dto;

import com.basis.srs.repositorio.EquipamentoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class EquipamentoServico {

    private final EquipamentoRepositorio equipamentoRepositorio;
    public EquipamentoServico(EquipamentoRepositorio equipamentoRepositorio) {
        this.equipamentoRepositorio = equipamentoRepositorio;
    }
}
